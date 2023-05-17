package _20_Jframe;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private Thread autoSaveThread;
    private Thread spellCheckThread;
    private List<String> dictionary;

    public static void main(String[] args) {
        new TextEditor();
    }

    public TextEditor() {
        super("Text Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                startAutoSaveThread();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Load the text from the file into the text area
        File file = new File("text.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line).append('\n');
                }
                textArea.setText(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Load the dictionary into an ArrayList
        dictionary = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("dict.txt"))) {
            String word;
            while ((word = reader.readLine()) != null) {
                dictionary.add(word.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Start the spell check thread
        startSpellCheckThread();

        setSize(600, 400);
        setVisible(true);
    }

    private void startAutoSaveThread() {
        if (autoSaveThread == null || !autoSaveThread.isAlive()) {
            autoSaveThread = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"))) {
                        writer.write(textArea.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            autoSaveThread.start();
        }
    }

    private void startSpellCheckThread() {
        if (spellCheckThread == null || !spellCheckThread.isAlive()) {
            spellCheckThread = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String text = textArea.getText().toLowerCase();
                    int start = 0;
                    while (start < text.length()) {
                        int end = text.indexOf(' ', start);
                        if (end == -1) {
                            end = text.length();
                        }
                        String word = text.substring(start, end);
                        if (!dictionary.contains(word)) {
                            // Highlight the misspelled word in red
                            int index = text.indexOf(word, start);
                            textArea.setCaretPosition(index);
                            textArea.select(index, index + word.length());
                            textArea.setSelectionColor
                                    (Color.RED);
                        }
                        start = end + 1;
                    }
                }
            });
            spellCheckThread.start();
        }
    }
}

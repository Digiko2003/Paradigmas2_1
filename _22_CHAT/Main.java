package _22_CHAT;
//By Diego Arturo Enriquez Mercado
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Read the following conversation: ");
        System.out.println();
        Menssage("megm", "Hi, there!", 2000);
        Menssage("kathyo", "Hi, Meg!", 2000);
        Menssage("megm", "What are you doing?", 2000);
        Menssage("kathyo", "I'm sitting on my bed with my laptop. I'm doing my homework.", 2000);
        Menssage("megm", "What are you working on?", 2000);
        Menssage("kathyo", "I'm writing an essay for Spanish class. :)", 2000);
        Menssage("megm", "Where are you?", 2000);
        Menssage("kathyo", "I'm in a cafe with my friend Carmen. I'm having coffee, and she's talking on the phone outside.", 2000);
        Menssage("kathyo", "How is your family?", 2000);
        Menssage("megm", "They're all fine! My father's watching a baseball game with his friends. My mother is out shopping.", 2000);
        Menssage("kathyo", "Where's your brother?", 2000);
        Menssage("megm", "John's playing soccer in the park.", 2000);
        Menssage("kathyo", "Oh, wait. My phone is ringing. My mother's calling me. I have to go! Bye!", 2000);
        Menssage("megm", "OK! Bye!", 2000);

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Answer the questions");
        System.out.println("Answers: (kathyo - carmen - megm - john)");
        System.out.println();

        String[] Preguntas = {
                "Who is writing an essay?",
                "Who is having coffee?",
                "Who is talking on the phone?",
                "Who is watching a baseball game?",
                "Who is shopping?",
                "Who is playing soccer?"
        };

        String[] Respuestas = {
                "kathyo",
                "kathyo",
                "carmen",
                "megm",
                "megm",
                "john"
        };

        for (int i = 0; i < Preguntas.length; i++) {
            String activity = Preguntas[i];
            String R_correctas = Respuestas[i];

            System.out.print(activity);

            // Retardo de 2 segundos
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String response = scanner.nextLine();
            System.out.println("Response: " + response);

            // Calificación y retroalimentación
            if (response.equalsIgnoreCase(R_correctas)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
                System.out.println("Correct answer: " + R_correctas);
            }
        }

        scanner.close();
    }

    public static void Menssage(String sender, String message, int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String formattedMessage = String.format("<%s>: %s", sender, message);
        for (char c : formattedMessage.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}










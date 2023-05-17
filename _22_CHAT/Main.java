package _22_CHAT;
//By Diego Arturo Enriquez Mercado
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Read the following conversation: ");
        System.out.println();
        sendMessageWithDelay("megm", "Hi, there!", 2000);
        sendMessageWithDelay("kathyo", "Hi, Meg!", 2000);
        sendMessageWithDelay("megm", "What are you doing?", 2000);
        sendMessageWithDelay("kathyo", "I'm sitting on my bed with my laptop. I'm doing my homework.", 2000);
        sendMessageWithDelay("megm", "What are you working on?", 2000);
        sendMessageWithDelay("kathyo", "I'm writing an essay for Spanish class. :)", 2000);
        sendMessageWithDelay("megm", "Where are you?", 2000);
        sendMessageWithDelay("kathyo", "I'm in a cafe with my friend Carmen. I'm having coffee, and she's talking on the phone outside.", 2000);
        sendMessageWithDelay("kathyo", "How is your family?", 2000);
        sendMessageWithDelay("megm", "They're all fine! My father's watching a baseball game with his friends. My mother is out shopping.", 2000);
        sendMessageWithDelay("kathyo", "Where's your brother?", 2000);
        sendMessageWithDelay("megm", "John's playing soccer in the park.", 2000);
        sendMessageWithDelay("kathyo", "Oh, wait. My phone is ringing. My mother's calling me. I have to go! Bye!", 2000);
        sendMessageWithDelay("megm", "OK! Bye!", 2000);

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Answer the questions");
        System.out.println("Answers: (kathyo - carmen - megm - john)");
        System.out.println();

        String[] activities = {
                "Who is writing an essay?",
                "Who is having coffee?",
                "Who is talking on the phone?",
                "Who is watching a baseball game?",
                "Who is shopping?",
                "Who is playing soccer?"
        };

        String[] correctAnswers = {
                "kathyo",
                "kathyo",
                "carmen",
                "megm",
                "megm",
                "john"
        };

        for (int i = 0; i < activities.length; i++) {
            String activity = activities[i];
            String correctAnswer = correctAnswers[i];

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
            if (response.equalsIgnoreCase(correctAnswer)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
                System.out.println("Correct answer: " + correctAnswer);
            }
        }

        scanner.close();
    }

    public static void sendMessageWithDelay(String sender, String message, int delay) {
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










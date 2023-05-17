package _22_CHAT;

import java.util.Scanner;


public class Preguntas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
}

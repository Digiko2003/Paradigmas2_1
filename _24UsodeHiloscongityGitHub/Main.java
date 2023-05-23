package _24UsodeHiloscongityGitHub;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println();

        String[] activities = {
                "Anne is Paul´s?",
                "Jason and Emily are their?",
                "Paul is Anne´s?",
                "Emily is Paul´s?",
                "Jason is Emily´s?",
                "Emily is Jason´s?",
                "Paul and Anne are Jason´s?"
        };

        String[] correctAnswers = {
                "wife",
                "children",
                "husban",
                "son",
                "dauther",
                "sister",
                "parents"
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
package com.footballquiz.controller;

import com.footballquiz.model.Question;
import com.footballquiz.service.QuizService;
import java.util.Scanner;

public class QuizController {

    private QuizService quizService;

    public QuizController() {
        this.quizService = new QuizService();
    }

    public void startQuiz() {
        int zeroPoint = 0;
        while (askIfContinue(zeroPoint)) {
            Question question = quizService.genarateQuestion();

            System.out.println("Question: " + question.getQuestion());

            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }

            // Simulate getting user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();
            if (question.getOptions().get(answer - 1).equals(question.getCorrectAnswer())) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong. The correct answer was: " + question.getCorrectAnswer());
            }
            zeroPoint++;
        }
    }

    public boolean askIfContinue(int zeroPoint) {
        if (zeroPoint != 0) {
            System.out.print("Do you want to continue to the next question? (yes/no): ");
            Scanner scanner = new Scanner(System.in);
            String userResponse = scanner.nextLine().trim().toLowerCase();
            return userResponse.equals("y");
        } else return true;
    }
}

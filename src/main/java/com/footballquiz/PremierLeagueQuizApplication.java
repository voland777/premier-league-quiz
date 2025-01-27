package com.footballquiz;

import com.footballquiz.controller.QuizController;

public class PremierLeagueQuizApplication {

    public static void main(String[] args) {
        QuizController quizController = new QuizController();

        // Start the quiz
        quizController.startQuiz();

    }
}

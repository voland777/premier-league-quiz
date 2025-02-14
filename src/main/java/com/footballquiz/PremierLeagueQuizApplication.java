package com.footballquiz;

import com.footballquiz.controller.ContinueController;
import com.footballquiz.controller.StartController;
import com.footballquiz.controller.ValidateAnswerController;
import com.footballquiz.model.Question;
import com.footballquiz.model.SeasonDto;
import com.footballquiz.service.*;
import com.footballquiz.view.ContinueView;
import com.footballquiz.view.StartView;

public class PremierLeagueQuizApplication {

    public static void main(String[] args) {
        InitService initService = new InitService();
        initService.addToList();
        StartController quizController = new StartController();
        ContinueController continueController = new ContinueController();


        StartView.startView();

        while (continueController.askIfContinue(ScannerService.scan())) {
            // Start the quiz
            QuizService quizService = new QuizService();
            Question question = quizService.genarateQuestion();
            quizController.startQuiz(question);

            // Validate answer
            ValidateAnswerController validateAnswerController = new ValidateAnswerController(ScannerService.scan());
            validateAnswerController.validateAnswer(question);
            ContinueView.continueView();
        }
    }

}

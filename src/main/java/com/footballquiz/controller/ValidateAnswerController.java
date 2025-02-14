package com.footballquiz.controller;

import com.footballquiz.model.Question;
import com.footballquiz.view.CorrectAnswerView;
import com.footballquiz.view.IncorrectAnswerView;

public class ValidateAnswerController {

    public String answer;
    public ValidateAnswerController(String answer) {
        this.answer = answer;
    }

    public void validateAnswer (Question question) {
        int numAnswer = Integer.parseInt(answer);
        if (question.getOptions().get(numAnswer - 1).equals(question.getCorrectAnswer())) {
            CorrectAnswerView.correctAnswerView();
        } else {
            IncorrectAnswerView.incorrectAnswerView(question.getCorrectAnswer());
        }
    }
}

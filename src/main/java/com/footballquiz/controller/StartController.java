package com.footballquiz.controller;

import com.footballquiz.model.Question;
import com.footballquiz.view.QuestionView;


public class StartController {

    public void startQuiz(Question question) {
        QuestionView.quizQuestion(question);
    }

}

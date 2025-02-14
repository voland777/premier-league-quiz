package com.footballquiz.view;

import com.footballquiz.model.Question;

public class QuestionView {

    public static void quizQuestion (Question question) {
        String quizQuestion = question.getQuestion();
        for (int i = 0; i < question.getOptions().size(); i++) {
            int k = i + 1;
            quizQuestion = quizQuestion + "\n" + k + ". " + question.getOptions().get(i);
        }
        quizQuestion = quizQuestion + "\n" + "Enter your answer:";
        System.out.println(quizQuestion);
    }

}

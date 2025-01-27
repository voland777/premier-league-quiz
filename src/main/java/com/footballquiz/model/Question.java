package com.footballquiz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Question {

    @Getter@Setter
    private String question;

    @Getter@Setter
    private String correctAnswer;

    @Getter@Setter
    private List<String> options;
}

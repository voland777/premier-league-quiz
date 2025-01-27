package com.footballquiz.service;

import com.footballquiz.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizService {

    public List<String> seasons = Arrays.asList("719", "578", "489", "418", "363");
    public Question genarateQuestion () {
        Question question = new Question();
        DataService dataService = new DataService(seasons);

        String season = dataService.getYearOfSeason();
        question.setQuestion("Who won Premier League in the " + season + " season?");

        question.setCorrectAnswer(dataService.getWinnerOfSeason());

        List<String> options = dataService.getRandomTeams();
        options.add(question.getCorrectAnswer());
        Collections.shuffle(options);
        question.setOptions(options);
        return question;
    };

}

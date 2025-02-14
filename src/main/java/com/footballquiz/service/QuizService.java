package com.footballquiz.service;

import com.footballquiz.model.Question;
import com.footballquiz.model.SeasonDto;

import java.util.Collections;
import java.util.List;

public class QuizService {

    public Question question;
    public DataService dataService = new DataService();

    public QuizService () {
        question = new Question();
    }

    public Question genarateQuestion () {
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

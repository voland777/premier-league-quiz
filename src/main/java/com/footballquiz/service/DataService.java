package com.footballquiz.service;

import com.footballquiz.model.PositionDto;
import com.footballquiz.model.SeasonDto;
import com.footballquiz.model.TeamDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DataService {

    private final SeasonDto season;
    private final List<PositionDto> positionList;

    public DataService () {
        this.season = SingletonListSeasons.getInstance().getRandomSeason();
        positionList = season.getPositionDtos();
    }

    public String getWinnerOfSeason () {
        String teamName = null;

        for (PositionDto position : positionList) {
            if (position.getPosition() == 1) {
                TeamDto team = position.getTeam();
                teamName = team.getName();
            }
        }
        return teamName;
    }

    public List<String> getRandomTeams () {
        List<PositionDto> pos = positionList;
        pos.remove(0);
        Collections.shuffle(pos);
        List<PositionDto> randomPos = pos.subList(0,3);
        List <String> randomTeams = new ArrayList<>();
        for (PositionDto position : randomPos) {
            TeamDto team = position.getTeam();
            String teamName = team.getName();
            randomTeams.add(teamName);
        }
        return randomTeams;
    }

    public String getYearOfSeason () {
        return season.getSeasonInfo().getLabel().toString();
    }
}

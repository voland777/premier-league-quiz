package com.footballquiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.footballquiz.model.PositionDto;
import com.footballquiz.model.SeasonDto;
import com.footballquiz.model.TableDto;
import com.footballquiz.model.TeamDto;
import com.footballquiz.util.HttpClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DataService {

    private List<String> season;

    public DataService(List<String> season) {
        this.season = season;
    }

    public String getSeasonData () {
        Random rand = new Random();
        String randomSeasonId = season.get(rand.nextInt(season.size()));
        return HttpClient.getFixturesTable(randomSeasonId);
    }

    public SeasonDto serializeSeasonData (String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(data, SeasonDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PositionDto> getPositionsList () {
        String data = getSeasonData();
        SeasonDto season = serializeSeasonData(data);
        TableDto tmp = season.getTableDto();
        return tmp.getPositionDtos();
    }
    public String getWinnerOfSeason () {
        List<PositionDto> pos = getPositionsList();
        String teamName = null;

        for (PositionDto position : pos) {
            if (position.getPosition() == 1) {
                TeamDto team = position.getTeam();
                teamName = team.getName();
            }
        }
        return teamName;
    }

    public List<String> getRandomTeams () {
        List<PositionDto> pos = getPositionsList();
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
        String data = getSeasonData();
        SeasonDto season = serializeSeasonData(data);
        return season.getSeasonInfo().getLabel().toString();
    }
}

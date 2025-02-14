package com.footballquiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.footballquiz.model.SeasonDto;
import com.footballquiz.util.HttpClient;

public class SeasonService {


    public String getSeasonData (String seasonId) {
        return HttpClient.getFixturesTable(seasonId);
    }

    public SeasonDto serializeSeasonData (String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(data, SeasonDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

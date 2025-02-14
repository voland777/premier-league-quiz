package com.footballquiz.service;

import com.footballquiz.model.SeasonDto;

import java.util.Arrays;
import java.util.List;

public class InitService {

    public List<String> seasons = Arrays.asList("719", "578", "489", "418", "363", "274", "210", "79");


    private SeasonService seasonService = new SeasonService();

    public void addToList () {
        String data;

        for (int i=0; i<seasons.size(); i++) {
            data = seasonService.getSeasonData(seasons.get(i));
            SeasonDto seasonDto = seasonService.serializeSeasonData(data);
            SingletonListSeasons.getInstance().addToListSeasons(seasonDto);
        }

    }
}

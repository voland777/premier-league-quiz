package com.footballquiz.service;

import com.footballquiz.model.SeasonDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SingletonListSeasons {

    private static SingletonListSeasons INSTANCE;

    private final List<SeasonDto> singletonListSeasons;

    private SingletonListSeasons() {
        this.singletonListSeasons = new ArrayList<SeasonDto>();
    }

    public static SingletonListSeasons getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonListSeasons();
        };
        return INSTANCE;
    }

    public List<SeasonDto> getListSeasons () {
        return singletonListSeasons;
    }

    public void addToListSeasons (SeasonDto seasonDto) {
        singletonListSeasons.add(seasonDto);
    }

    public SeasonDto getRandomSeason () {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(singletonListSeasons.size());
        SeasonDto seasonDto = singletonListSeasons.get(index);
        singletonListSeasons.remove(index);
        return seasonDto;
    }

}

package com.footballquiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.footballquiz.serialization.CompetitionDeserializer;
import com.footballquiz.serialization.PositionsArrayDeserializer;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonInfoDto {

    @Getter
    @Setter
    @JsonProperty(value = "label")
    private String label;

    @Getter
    @JsonDeserialize(using = CompetitionDeserializer.class)
    @JsonProperty(value = "competition")
    private String competition;
}

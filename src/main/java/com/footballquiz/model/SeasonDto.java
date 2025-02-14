package com.footballquiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.footballquiz.serialization.PositionsArrayDeserializer;
import lombok.Getter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonDto {

    @Getter
    @JsonProperty(value = "compSeason")
    private SeasonInfoDto seasonInfo;

    @Getter
    @JsonDeserialize(using = PositionsArrayDeserializer.class)
    @JsonProperty(value = "tables")
    private List<PositionDto> positionDtos;
}

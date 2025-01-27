package com.footballquiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntryDto {
    @JsonProperty(value = "gameWeek")
    private String gameWeek;

    @Getter@Setter
    @JsonProperty()
    private List<PositionDto> positionDto;
}

package com.footballquiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonInfoDto {

    @Getter
    @Setter
    @JsonProperty(value = "label")
    private String label;
}

package com.footballquiz.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.footballquiz.serialization.TableDeserializer;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SeasonDto {

    @Getter @Setter
    @JsonProperty(value = "live")
    private String live;

    @Getter @Setter
    @JsonProperty(value = "compSeason")
    private SeasonInfoDto seasonInfo;


    @Getter @Setter
    @JsonDeserialize(using = TableDeserializer.class)
    @JsonProperty(value = "tables")
    private TableDto tableDto;
}

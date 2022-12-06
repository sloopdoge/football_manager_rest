package com.example.footballmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class PlayersDto {

    @JsonProperty("players_id")
    private Long id;

    @NotNull
    @JsonProperty("full_name")
    private String fullName;

    @NotNull
    @JsonProperty("age")
    private Integer age;

    @NotNull
    @JsonProperty("experience")
    private Integer experience;
}

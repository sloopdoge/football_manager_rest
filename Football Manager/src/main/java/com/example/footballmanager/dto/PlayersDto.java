package com.example.footballmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@Builder
public class PlayersDto {

    @Null
    @JsonProperty("id")
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

    @JsonProperty("teams_id")
    private Long teamId;
}

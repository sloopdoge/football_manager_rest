package com.example.footballmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class TeamsDto {

    @JsonProperty("teams_id")
    private Long id;

    @NotNull
    @JsonProperty("title")
    private String title;

    @NotNull
    @JsonProperty("account")
    private Double account;

    @NotNull
    @JsonProperty("tax")
    private Double tax;

    @JsonProperty("members")
    private List<PlayersDto> members;

}

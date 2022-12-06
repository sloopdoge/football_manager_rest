package com.example.footballmanager.service;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.dto.TeamsDto;

public interface TeamsService {
    TeamsDto createTeam(TeamsDto teamsDto);
    TeamsDto getTeam(Long teamId);
    TeamsDto updateTeam(TeamsDto teamsDto, Long teamId);
    TeamsDto deleteTeam(Long teamId);
    TeamsDto addPlayerToTeam(Long teamId, Long playerId);
    TeamsDto transferPlayer(Long teamId, Long playerId);
}

package com.example.footballmanager.service;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.dto.TeamsDto;

public interface PlayersService {
    PlayersDto createPlayer(PlayersDto playersDto);
    PlayersDto getPlayer(Long playerId);
    PlayersDto updatePlayer(PlayersDto playersDto, Long playerId);
    PlayersDto deletePlayer(Long playerId);
    PlayersDto addPlayerToTeam(Long playerId, Long teamId);
}

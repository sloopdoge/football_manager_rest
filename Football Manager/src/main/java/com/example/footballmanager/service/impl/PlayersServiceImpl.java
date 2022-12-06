package com.example.footballmanager.service.impl;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.exception.EntityDoesNotExistException;
import com.example.footballmanager.mapper.PlayersMapper;
import com.example.footballmanager.repository.PlayersRepository;
import com.example.footballmanager.service.PlayersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService {

    final PlayersRepository repository;
    final PlayersMapper mapper;

    @Override
    public PlayersDto createPlayer(PlayersDto playersDto) {
        return mapper.convert(repository.save(mapper.convert(playersDto)));
    }

    @Override
    public PlayersDto getPlayer(Long playerId) {
        var searchablePlayer = repository.findById(playerId);

        if (!searchablePlayer.isPresent()) {
            throw new EntityDoesNotExistException("Player does not exist");
        }

        return mapper.convert(searchablePlayer.get());
    }

    @Override
    public PlayersDto updatePlayer(PlayersDto playersDto, Long playerId) {
        var currentPlayer = repository.findById(playerId);

        if (!currentPlayer.isPresent()) {
            throw new EntityDoesNotExistException("Player does not exist");
        }

        var receivedPlayer = mapper.convert(playersDto);
        var updatedPlayer = mapper.updateEntity(receivedPlayer, currentPlayer.get());

        return mapper.convert(updatedPlayer);
    }

    @Override
    public PlayersDto deletePlayer(Long playerId) {
        var player = repository.findById(playerId);

        if (!player.isPresent()) {
            throw new EntityDoesNotExistException("Player does not exist");
        }

        repository.delete(player.get());

        return mapper.convert(player.get());
    }
}

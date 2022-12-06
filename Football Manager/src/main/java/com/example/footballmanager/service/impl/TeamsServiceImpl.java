package com.example.footballmanager.service.impl;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.dto.TeamsDto;
import com.example.footballmanager.entity.Players;
import com.example.footballmanager.exception.EntityAlreadyInUseException;
import com.example.footballmanager.exception.EntityDoesNotExistException;
import com.example.footballmanager.mapper.PlayersMapper;
import com.example.footballmanager.mapper.TeamsMapper;
import com.example.footballmanager.repository.PlayersRepository;
import com.example.footballmanager.repository.TeamsRepository;
import com.example.footballmanager.service.TeamsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamsServiceImpl implements TeamsService {

    final TeamsRepository teamsRepository;
    final PlayersRepository playersRepository;

    final TeamsMapper teamsMapper;
    final PlayersMapper playersMapper;

    @Override
    public TeamsDto createTeam(TeamsDto teamsDto) {
        return teamsMapper.convert(teamsRepository.save(teamsMapper.convert(teamsDto)));
    }

    @Override
    public TeamsDto getTeam(Long teamId) {
        var searchableTeam = teamsRepository.findById(teamId);

        if (!searchableTeam.isPresent()) {
            throw new EntityDoesNotExistException("Team does not exist");
        }

        return teamsMapper.convert(searchableTeam.get());
    }

    @Override
    public TeamsDto updateTeam(TeamsDto teamsDto, Long teamId) {
        var currentTeam = teamsRepository.findById(teamId);

        if (!currentTeam.isPresent()) {
            throw new EntityDoesNotExistException("Team does not exist");
        }

        var receivedTeam = teamsMapper.convert(teamsDto);
        var updatedTeam = teamsMapper.updateEntity(receivedTeam, currentTeam.get());

        return teamsMapper.convert(updatedTeam);
    }

    @Override
    public TeamsDto deleteTeam(Long teamId) {
        var team = teamsRepository.findById(teamId);

        if (!team.isPresent()) {
            throw new EntityDoesNotExistException("Team does not exist");
        }

        teamsRepository.delete(team.get());

        return teamsMapper.convert(team.get());
    }
}

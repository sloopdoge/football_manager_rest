package com.example.footballmanager.service.impl;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.entity.Players;
import com.example.footballmanager.exception.EntityDoesNotExistException;
import com.example.footballmanager.mapper.PlayersMapper;
import com.example.footballmanager.mapper.TeamsMapper;
import com.example.footballmanager.repository.PlayersRepository;
import com.example.footballmanager.repository.TeamsRepository;
import com.example.footballmanager.service.PlayersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayersServiceImpl implements PlayersService {

    final PlayersRepository playersRepository;
    final TeamsRepository teamsRepository;
    final PlayersMapper playersMapper;
    final TeamsMapper teamsMapper;

    @Override
    public PlayersDto createPlayer(PlayersDto playersDto) {
        var player = playersRepository.save(playersMapper.convert(playersDto));

        if (player.getTeamId() != null) {
            var team = teamsRepository.findById(playersDto.getTeamId());
            if (!team.isPresent()) {
                throw new EntityDoesNotExistException("Team does not exist");
            }

            List<Players> members = team.get().getMembers();
            members.add(player);
            team.get().setMembers(members);
            teamsMapper.updateEntity(team.get(), team.get());
        }

        return playersMapper.convert(player);
    }

    @Override
    public PlayersDto getPlayer(Long playerId) {
        var searchablePlayer = playersRepository.findById(playerId);

        if (!searchablePlayer.isPresent()) {
            throw new EntityDoesNotExistException("Player does not exist");
        }

        return playersMapper.convert(searchablePlayer.get());
    }

    @Override
    @Transactional
    public PlayersDto updatePlayer(PlayersDto playersDto, Long playerId) {
        var currentPlayer = playersRepository.findById(playerId);

        if (!currentPlayer.isPresent()) {
            throw new EntityDoesNotExistException("Player does not exist");
        }

        var receivedPlayer = playersMapper.convert(playersDto);
        var updatedPlayer = playersMapper.updateEntity(receivedPlayer, currentPlayer.get());

        return playersMapper.convert(updatedPlayer);
    }

    @Override
    public PlayersDto deletePlayer(Long playerId) {
        var player = playersRepository.findById(playerId);

        if (!player.isPresent()) {
            throw new EntityDoesNotExistException("Player does not exist");
        }

        playersRepository.delete(player.get());

        return playersMapper.convert(player.get());
    }

    @Override
    @Transactional
    public PlayersDto addPlayerToTeam(Long playerId, Long teamId) {
        var player = playersRepository.findById(playerId);
        var buyerTeam = teamsRepository.findById(teamId);
        if (!player.isPresent()) {
            throw new EntityDoesNotExistException("Player does not exist");
        }
        if (!buyerTeam.isPresent()) {
            throw new EntityDoesNotExistException("Team does not exist");
        }

        var buyerTeamMembers = buyerTeam.get().getMembers();

        var sellerTeam = teamsRepository.findById(player.get().getTeamId());
        var sellerTeamMembers = buyerTeam.get().getMembers();

        Double playerPrice = Double.valueOf((player.get().getExperience() * 100000)/(player.get().getAge()));
        Double fullPrice = playerPrice+((buyerTeam.get().getTax()/100)*playerPrice);

        sellerTeamMembers.remove(player.get());
        buyerTeamMembers.add(player.get());
        player.get().setTeamId(buyerTeam.get().getId());


        Double sellerTeamAccount = sellerTeam.get().getAccount();
        sellerTeam.get().setAccount((sellerTeamAccount + fullPrice));
        Double buyerTeamAccount = buyerTeam.get().getAccount();
        buyerTeam.get().setAccount(buyerTeamAccount-fullPrice);

        return playersMapper.convert(player.get());
    }
}

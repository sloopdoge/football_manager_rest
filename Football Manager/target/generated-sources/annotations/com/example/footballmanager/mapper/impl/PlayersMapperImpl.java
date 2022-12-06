package com.example.footballmanager.mapper.impl;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.entity.Players;
import com.example.footballmanager.mapper.PlayersMapper;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-05T01:54:39+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class PlayersMapperImpl implements PlayersMapper {

    @Override
    public Players convert(PlayersDto playersDto) {
        if ( playersDto == null ) {
            return null;
        }

        Players.PlayersBuilder players = Players.builder();

        if ( playersDto.getId() != null ) {
            players.id( playersDto.getId() );
        }
        if ( playersDto.getFullName() != null ) {
            players.fullName( playersDto.getFullName() );
        }
        if ( playersDto.getAge() != null ) {
            players.age( playersDto.getAge() );
        }
        if ( playersDto.getExperience() != null ) {
            players.experience( playersDto.getExperience() );
        }

        return players.build();
    }

    @Override
    public PlayersDto convert(Players players) {
        if ( players == null ) {
            return null;
        }

        PlayersDto.PlayersDtoBuilder playersDto = PlayersDto.builder();

        if ( players.getId() != null ) {
            playersDto.id( players.getId() );
        }
        if ( players.getFullName() != null ) {
            playersDto.fullName( players.getFullName() );
        }
        if ( players.getAge() != null ) {
            playersDto.age( players.getAge() );
        }
        if ( players.getExperience() != null ) {
            playersDto.experience( players.getExperience() );
        }

        return playersDto.build();
    }

    @Override
    public Players updateEntity(Players source, Players target) {
        if ( source == null ) {
            return target;
        }

        if ( source.getFullName() != null ) {
            target.setFullName( source.getFullName() );
        }
        if ( source.getAge() != null ) {
            target.setAge( source.getAge() );
        }
        if ( source.getExperience() != null ) {
            target.setExperience( source.getExperience() );
        }

        return target;
    }
}

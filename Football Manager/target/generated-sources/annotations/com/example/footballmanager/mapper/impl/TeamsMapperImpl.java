package com.example.footballmanager.mapper.impl;

import com.example.footballmanager.dto.TeamsDto;
import com.example.footballmanager.entity.Players;
import com.example.footballmanager.entity.Teams;
import com.example.footballmanager.mapper.TeamsMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-05T01:54:38+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class TeamsMapperImpl implements TeamsMapper {

    @Override
    public Teams convert(TeamsDto teamsDto) {
        if ( teamsDto == null ) {
            return null;
        }

        Teams.TeamsBuilder teams = Teams.builder();

        if ( teamsDto.getId() != null ) {
            teams.id( teamsDto.getId() );
        }
        if ( teamsDto.getTitle() != null ) {
            teams.title( teamsDto.getTitle() );
        }
        if ( teamsDto.getAccount() != null ) {
            teams.account( teamsDto.getAccount() );
        }

        return teams.build();
    }

    @Override
    public TeamsDto convert(Teams teams) {
        if ( teams == null ) {
            return null;
        }

        TeamsDto.TeamsDtoBuilder teamsDto = TeamsDto.builder();

        if ( teams.getId() != null ) {
            teamsDto.id( teams.getId() );
        }
        if ( teams.getTitle() != null ) {
            teamsDto.title( teams.getTitle() );
        }
        if ( teams.getAccount() != null ) {
            teamsDto.account( teams.getAccount() );
        }

        return teamsDto.build();
    }

    @Override
    public Teams updateEntity(Teams source, Teams target) {
        if ( source == null ) {
            return target;
        }

        if ( source.getTitle() != null ) {
            target.setTitle( source.getTitle() );
        }
        if ( source.getAccount() != null ) {
            target.setAccount( source.getAccount() );
        }
        if ( target.getMembers() != null ) {
            List<Players> list = source.getMembers();
            if ( list != null ) {
                target.getMembers().clear();
                target.getMembers().addAll( list );
            }
        }
        else {
            List<Players> list = source.getMembers();
            if ( list != null ) {
                target.setMembers( new ArrayList<Players>( list ) );
            }
        }

        return target;
    }
}

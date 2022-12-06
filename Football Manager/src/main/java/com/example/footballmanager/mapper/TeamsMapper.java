package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.TeamsDto;
import com.example.footballmanager.entity.Players;
import com.example.footballmanager.entity.Teams;
import org.mapstruct.*;

@Mapper(config = TeamsConfigMapper.class)
public interface TeamsMapper {
    Teams convert(TeamsDto teamsDto);

    TeamsDto convert(Teams teams);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({@Mapping(target = "id", ignore = true)})
    Teams updateEntity(final Teams source, @MappingTarget Teams target);
}

package com.example.footballmanager.mapper;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.entity.Players;
import org.mapstruct.*;

@Mapper(config = PlayersConfigMapper.class)
public interface PlayersMapper {
    Players convert(PlayersDto playersDto);

    PlayersDto convert(Players players);

    @BeanMapping(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mappings({@Mapping(target = "id", ignore = true)})
    Players updateEntity(final Players source, @MappingTarget Players target);
}

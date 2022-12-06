package com.example.footballmanager.api;

import com.example.footballmanager.dto.PlayersDto;
import com.example.footballmanager.service.PlayersService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PlayersController {
    @Autowired
    private final PlayersService service;

    @Operation(summary = "Create Player")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/players")
    public PlayersDto createPlayer(@RequestBody final PlayersDto playersDto) {
        return service.createPlayer(playersDto);
    }

    @Operation(summary = "Get Player")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/players/{id}")
    public PlayersDto getPlayer(@PathVariable("id") final Long playerId) {
        return service.getPlayer(playerId);
    }

    @Operation(summary = "Update Player")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/players/{id}")
    public PlayersDto updatePlayer(@RequestBody final PlayersDto playersDto, @PathVariable("id") final Long playerId) {
        return service.updatePlayer(playersDto, playerId);
    }

    @Operation(summary = "Delete Player")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/players/{id}")
    public PlayersDto deletePlayer(@PathVariable("id") final Long playerId) {
        return service.deletePlayer(playerId);
    }
}

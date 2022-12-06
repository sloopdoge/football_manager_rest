package com.example.footballmanager.api;

import com.example.footballmanager.dto.TeamsDto;
import com.example.footballmanager.service.TeamsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TeamsController {
    @Autowired
    private final TeamsService service;

    @Operation(summary = "Create Team")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/teams")
    public TeamsDto createTeam(@RequestBody final TeamsDto teamsDto) {
        return service.createTeam(teamsDto);
    }

    @Operation(summary = "Get Team")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/teams/{id}")
    public TeamsDto getTeam(@PathVariable("id") final Long teamId) {
        return service.getTeam(teamId);
    }

    @Operation(summary = "Update Team")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/teams/{id}")
    public TeamsDto updateTeam(@RequestBody final TeamsDto teamsDto, @PathVariable("id") final Long teamId) {
        return service.updateTeam(teamsDto, teamId);
    }

    @Operation(summary = "Delete Team")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/teams/{id}")
    public TeamsDto deleteTeam(@PathVariable("id") final Long teamId) {
        return service.deleteTeam(teamId);
    }
}

package com.restAPIremastered.service.impl;

import com.restAPIremastered.persistance.dto.TeamDTO;
import com.restAPIremastered.persistance.entity.Team;
import com.restAPIremastered.persistance.repository.TeamRepository;
import com.restAPIremastered.service.TeamService2;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl2 implements TeamService2 {

    private final TeamRepository teamRepository;
    private final ModelMapper modelMapper; // Requires ModelMapper library

    @Transactional
    @Override
    public List<TeamDTO> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public TeamDTO getTeamById(int teamId) {
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team != null) {
            return convertToDto(team);
        }
        return null;
    }
    @Transactional
    @Override
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = convertToEntity(teamDTO);
        Team savedTeam = teamRepository.save(team);
        return convertToDto(savedTeam);
    }

    @Transactional
    @Override
    public void deleteTeam(int teamId) {
        teamRepository.deleteById(teamId);
    }

    private TeamDTO convertToDto(Team team) {
        return modelMapper.map(team, TeamDTO.class);
    }

    private Team convertToEntity(TeamDTO teamDTO) {
        return modelMapper.map(teamDTO, Team.class);
    }

    @Override
    public List<TeamDTO> getTeamsByRoundId(int roundId) {
        List<Team> teams = teamRepository.getTeamsByRoundId(roundId);
        return teams.stream()
                .map(team -> modelMapper.map(team, TeamDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void flush() {
        teamRepository.flush();
    }
}
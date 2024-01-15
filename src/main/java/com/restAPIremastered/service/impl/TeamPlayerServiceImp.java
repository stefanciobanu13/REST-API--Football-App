package com.restAPIremastered.service.impl;

import com.restAPIremastered.persistance.dto.TeamPlayerDTO;
import com.restAPIremastered.persistance.entity.TeamPlayer;
import com.restAPIremastered.persistance.repository.TeamPlayerRepository;
import com.restAPIremastered.service.TeamPlayerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamPlayerServiceImp implements TeamPlayerService {

    private final TeamPlayerRepository teamPlayerRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void saveTeamPlayer(TeamPlayerDTO teamPlayerDTO) {
        TeamPlayer teamPlayer = modelMapper.map(teamPlayerDTO, TeamPlayer.class);
        teamPlayerRepository.save(teamPlayer);
    }

    @Override
    @Transactional
    public List<TeamPlayerDTO> getTeamPlayers() {
        List<TeamPlayer> teamPlayers = teamPlayerRepository.findAll();
        return teamPlayers.stream()
                .map(teamPlayer -> modelMapper.map(teamPlayer, TeamPlayerDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TeamPlayerDTO getTeamPlayer(int teamPlayerId) {
        Optional<TeamPlayer> optionalTeamPlayer = teamPlayerRepository.findById(teamPlayerId);
        return optionalTeamPlayer.map(teamPlayer -> modelMapper.map(teamPlayer, TeamPlayerDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteTeamPlayer(int teamPlayerId) {
        teamPlayerRepository.deleteById(teamPlayerId);
    }
}
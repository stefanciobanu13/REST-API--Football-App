package com.restAPIremastered.service;


import com.restAPIremastered.persistance.dto.TeamPlayerDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamPlayerService {

    void saveTeamPlayer(TeamPlayerDTO teamPlayerDTO);

    List<TeamPlayerDTO> getTeamPlayers();

    TeamPlayerDTO getTeamPlayer(int theId);

    void deleteTeamPlayer(int theId);
}
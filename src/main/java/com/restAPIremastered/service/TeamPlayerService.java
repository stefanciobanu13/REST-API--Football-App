package com.restAPIremastered.service;


import com.restAPIremastered.persistance.dto.TeamPlayerDTO;
import com.restAPIremastered.persistance.entity.TeamPlayer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamPlayerService {

    List<TeamPlayer> getTeamPlayerByRoundId(int roundId);

    void saveTeamPlayer(TeamPlayerDTO teamPlayerDTO);

    List<TeamPlayerDTO> getTeamPlayers();

    TeamPlayerDTO getTeamPlayer(int theId);

    void deleteTeamPlayer(int theId);
    void flush();
}
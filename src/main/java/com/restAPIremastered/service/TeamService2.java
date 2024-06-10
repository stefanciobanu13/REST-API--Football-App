package com.restAPIremastered.service;

import com.restAPIremastered.persistance.dto.TeamDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeamService2 {

    List<TeamDTO> getTeams();
    TeamDTO getTeamById(int teamId);
    TeamDTO createTeam(TeamDTO teamDTO);
    void deleteTeam(int teamId);
    List<TeamDTO> getTeamsByRoundId(int roundId);
     void flush();
}
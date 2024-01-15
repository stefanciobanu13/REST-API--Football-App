package com.restAPIremastered.service;

import com.restAPIremastered.persistance.dto.TeamDTO;
import java.util.List;

public interface TeamService2 {

    List<TeamDTO> getTeams();
    TeamDTO getTeamById(int teamId);
    TeamDTO createTeam(TeamDTO teamDTO);
    void deleteTeam(int teamId);
}
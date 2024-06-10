package com.restAPIremastered.service.impl;

import com.restAPIremastered.persistance.entity.Team;
import com.restAPIremastered.persistance.repository.TeamRepository;
import com.restAPIremastered.service.TeamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImp implements TeamService {

    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImp(TeamRepository teamRepository) {
        this.teamRepository = TeamServiceImp.this.teamRepository;
    }

    @Transactional
    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Transactional
    @Override
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @Transactional
    @Override
    public Team getTeam(int theId) {
        Optional<Team> optionalTeam = teamRepository.findById(theId);
        return optionalTeam.orElse(null);
    }

    @Transactional
    @Override
    public void deleteTeam(int theId) {
        teamRepository.deleteById(theId);
    }
}






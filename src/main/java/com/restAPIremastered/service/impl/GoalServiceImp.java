package com.restAPIremastered.service.impl;

import com.restAPIremastered.persistance.dto.GoalDTO;
import com.restAPIremastered.persistance.entity.Goal;
import com.restAPIremastered.persistance.repository.GoalRepository;
import com.restAPIremastered.service.GoalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalServiceImp implements GoalService {

    private final GoalRepository goalDAO;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void saveGoal(GoalDTO goalDTO) {
        Goal goal = modelMapper.map(goalDTO, Goal.class);
        goalDAO.save(goal);
    }

    @Override
    @Transactional
    public List<GoalDTO> getGoals() {
        List<Goal> goals = goalDAO.findAll();
        return goals.stream()
                .map(goal -> modelMapper.map(goal, GoalDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GoalDTO getGoal(int goalId) {
        Optional<Goal> optionalGoal = goalDAO.findById(goalId);
        return optionalGoal.map(goal -> modelMapper.map(goal, GoalDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteGoal(int goalId) {
        goalDAO.deleteById(goalId);
    }
}






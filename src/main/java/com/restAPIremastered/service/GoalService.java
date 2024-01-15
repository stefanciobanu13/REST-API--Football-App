package com.restAPIremastered.service;

import com.restAPIremastered.persistance.dto.GoalDTO;

import java.util.List;

public interface GoalService {

    void saveGoal(GoalDTO goalDTO);

    List<GoalDTO> getGoals();

    GoalDTO getGoal(int goalId);

    void deleteGoal(int goalId);
}
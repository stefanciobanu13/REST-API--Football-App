package com.restAPIremastered.persistance.repository;

import com.restAPIremastered.persistance.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal,Integer> {
}

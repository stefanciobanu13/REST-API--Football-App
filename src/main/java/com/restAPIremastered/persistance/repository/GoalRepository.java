package com.restAPIremastered.persistance.repository;

import com.restAPIremastered.persistance.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal,Integer> {

    @Query("SELECT gl FROM Goal gl " +
            " INNER JOIN Game gm ON gl.game.id = gm.id " +
            " INNER JOIN Round r ON r.id = gm.round.id" +
            " WHERE r.id = :roundId")
    List<Goal> getGoalsByRoundId(@Param("roundId") int roundId);
}

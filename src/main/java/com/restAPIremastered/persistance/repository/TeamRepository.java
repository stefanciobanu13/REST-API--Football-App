package com.restAPIremastered.persistance.repository;

import com.restAPIremastered.persistance.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query("SELECT t FROM Team t " +
            " INNER JOIN Round r ON t.round.id = r.id " +
            " WHERE r.id = :roundId")
    List<Team> getTeamsByRoundId(@Param("roundId") int roundId);
}
package com.restAPIremastered.persistance.repository;

import com.restAPIremastered.persistance.entity.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Integer> {

    @Query("SELECT tp FROM TeamPlayer tp " +
            " INNER JOIN Team t ON tp.team.id = t.id " +
            " INNER JOIN Round r ON t.round.id = r.id " +
            " WHERE r.id = :roundId")
    List<TeamPlayer> getTeamPlayerByRoundId(@Param("roundId") int roundId);
}
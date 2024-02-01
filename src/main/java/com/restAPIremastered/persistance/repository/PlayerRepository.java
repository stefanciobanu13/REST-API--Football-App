package com.restAPIremastered.persistance.repository;


import com.restAPIremastered.persistance.dto.RoundPlayerDTO;
import com.restAPIremastered.persistance.dto.ScorerDTO;
import com.restAPIremastered.persistance.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    @Query("SELECT p FROM Player p WHERE p.firstName = :firstName AND p.lastName = :lastName")
    Player findPlayerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);


    @Query("SELECT new com.restAPIremastered.persistance.dto.RoundPlayerDTO(" +
            "CONCAT(p.firstName, ' ', p.lastName), " +
            "t.color) " +
            "FROM Round r " +
            "INNER JOIN Team t ON r.id = t.round.id " +
            "INNER JOIN TeamPlayer tp ON t.id = tp.team.id " +
            "INNER JOIN Player p ON p.id = tp.player.id " +
            "WHERE r.id = :roundId " )
//            "ORDER BY t.color")
    List<RoundPlayerDTO> findRoundPlayersByRoundId(@Param("roundId") int roundId);

    @Query("SELECT new com.restAPIremastered.persistance.dto.ScorerDTO(" +
            "CONCAT(p.firstName, ' ', p.lastName), g.number, tm.color, " +
            "COUNT(distinct gl.id)) " +
            "FROM Goal gl " +
            "JOIN gl.game g " +
            "JOIN g.round r " +
            "JOIN gl.player p " +
            "JOIN gl.team tm " +
            "WHERE r.id = :roundId " +
            "AND gl.ownGoal = false " +
            "GROUP BY p.id, r.id, g.number " +
            "ORDER BY g.number ASC")
    List<ScorerDTO> findScorersByRoundId(@Param("roundId") int roundId);


    @Query("SELECT new com.restAPIremastered.persistance.dto.ScorerDTO(" +
            "CONCAT(p.firstName, ' ', p.lastName), g.number, tm.color, " +
            "COUNT(distinct gl.id)) " +
            "FROM Goal gl " +
            "JOIN gl.game g " +
            "JOIN g.round r " +
            "JOIN gl.player p " +
            "JOIN gl.team tm " +
            "WHERE r.id = :roundId " +
            "AND gl.ownGoal = true " +  // Select only own goals
            "GROUP BY p.id, r.id, g.number " +
            "ORDER BY g.number ASC")
    List<ScorerDTO> findOwnGoalsScorersByRoundId(@Param("roundId") int roundId);


}


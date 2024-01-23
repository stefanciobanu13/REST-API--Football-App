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
            "CONCAT(p.firstName, ' ', p.lastName), " +
            "g.number, " +
            "COUNT(goal.id)) " +
            "FROM Player p " +
            "JOIN Goal goal ON p.id = goal.player.id " +
            "JOIN Game g ON goal.game.id = g.id " +
            "WHERE g.round.id = :roundId " +
            "GROUP BY p.id, g.number " )

    List<ScorerDTO> findPlayerScoresByRoundId(@Param("roundId") int roundId);

}

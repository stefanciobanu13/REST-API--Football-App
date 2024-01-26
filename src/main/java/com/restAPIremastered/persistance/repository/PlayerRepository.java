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
            "gm.number, " +
            "tm.color, " +
            "COUNT(gl.id)) " +
            "FROM Game gm " +
            "JOIN gm.round r " +
            "LEFT JOIN gm.team1 tm1 " +
            "LEFT JOIN gm.team2 tm2 " +
            "LEFT JOIN Team tm ON (tm1.id = tm.id OR tm2.id = tm.id) " +
            "LEFT JOIN TeamPlayer tp ON tm.id = tp.team.id " +
            "LEFT JOIN tp.player p " +
            "LEFT JOIN Goal gl ON (p.id = gl.player.id AND gm.id = gl.game.id) " +
            "WHERE r.id = :roundId " +
            "GROUP BY p.id, r.id, gm.number " +
            "HAVING COUNT(gl.id) > 0")
    List<ScorerDTO> findScorersByRoundId(@Param("roundId") int roundId);




}


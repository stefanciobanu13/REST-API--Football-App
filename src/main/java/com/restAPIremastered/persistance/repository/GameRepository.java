package com.restAPIremastered.persistance.repository;


import com.restAPIremastered.persistance.dto.GameInfoDTO;
import com.restAPIremastered.persistance.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Integer> {

    @Query("SELECT new com.restAPIremastered.persistance.dto.GameInfoDTO(" +
            "g.number, t1.color, t2.color, g.team1Goals, g.team2Goals) " +
            "FROM Game g " +
            "JOIN Team t1 ON g.team1.id = t1.id " +
            "JOIN Team t2 ON g.team2.id = t2.id " +
            "WHERE g.round.id = :roundId")
    List<GameInfoDTO> getGamesInfoForRound(@Param("roundId") int roundId);

}

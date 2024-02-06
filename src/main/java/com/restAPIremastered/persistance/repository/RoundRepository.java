package com.restAPIremastered.persistance.repository;

import com.restAPIremastered.persistance.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoundRepository extends JpaRepository<Round,Integer> {

    @Query("SELECT g FROM Round g WHERE g.date = :roundDate")
    public Round findByRoundDate(@Param("roundDate") String roundDate);

    @Query("SELECT g FROM Round g WHERE g.number = :roundNumber")
    public Round findByRoundNumber(@Param("roundNumber") int roundNumber);

}

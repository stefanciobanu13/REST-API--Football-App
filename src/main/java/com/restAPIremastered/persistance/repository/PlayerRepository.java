package com.restAPIremastered.persistance.repository;


import com.restAPIremastered.persistance.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {

    @Query("SELECT p FROM Player p WHERE p.firstName = :firstName AND p.lastName = :lastName")
    Player findPlayerByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}

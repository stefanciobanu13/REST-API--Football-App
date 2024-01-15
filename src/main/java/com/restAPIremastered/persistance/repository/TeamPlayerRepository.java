package com.restAPIremastered.persistance.repository;

import com.restAPIremastered.persistance.entity.TeamPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamPlayerRepository extends JpaRepository<TeamPlayer, Integer> {

    // You can add custom query methods here if needed
}
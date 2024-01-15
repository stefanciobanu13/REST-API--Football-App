package com.restAPIremastered.persistance.repository;


import com.restAPIremastered.persistance.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {

}

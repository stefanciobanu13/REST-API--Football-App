package com.restAPIremastered.service;
import com.restAPIremastered.persistance.dto.GameDTO;

import java.util.List;

public interface GameService {

    GameDTO saveGame(GameDTO gameDTO);

    List<GameDTO> getGames();

    GameDTO getGame(int gameId);

    void deleteGame(int gameId);
}
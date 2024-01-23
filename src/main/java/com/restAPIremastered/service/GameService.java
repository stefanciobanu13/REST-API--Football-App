package com.restAPIremastered.service;
import com.restAPIremastered.persistance.dto.GameDTO;
import com.restAPIremastered.persistance.dto.GameInfoDTO;

import java.util.List;

public interface GameService {

    GameDTO saveGame(GameDTO gameDTO);

    List<GameDTO> getGames();

    GameDTO getGame(int gameId);

    void deleteGame(int gameId);
    List<GameInfoDTO> getGamesByRoundId(int roundId);
}
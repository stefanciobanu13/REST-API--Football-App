package com.restAPIremastered.service.impl;
import com.restAPIremastered.persistance.dto.GameDTO;
import com.restAPIremastered.persistance.dto.GameInfoDTO;
import com.restAPIremastered.persistance.entity.Game;
import com.restAPIremastered.persistance.repository.GameRepository;
import com.restAPIremastered.service.GameService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameServiceImp implements GameService {

    @Autowired
    private final GameRepository gameRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public GameDTO saveGame(GameDTO gameDTO) {
        Game game = modelMapper.map(gameDTO, Game.class);
        System.out.println("Thegame is " + game);
       return modelMapper.map(gameRepository.save(game),GameDTO.class);
    }

    @Override
    @Transactional
    public List<GameDTO> getGames() {
        List<Game> games = gameRepository.findAll();
        return games.stream()
                .map(game -> modelMapper.map(game, GameDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public GameDTO getGame(int gameId) {
        Optional<Game> optionalGame = gameRepository.findById(gameId);
        return optionalGame.map(game -> modelMapper.map(game, GameDTO.class)).orElse(null);
    }

    @Override
    @Transactional
    public void deleteGame(int gameId) {
        try{
            gameRepository.deleteById(gameId);
            System.out.println("The game was deleted succesfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<GameInfoDTO> getGamesByRoundId(int roundId) {
        return gameRepository.getGamesInfoForRound(roundId);
    }

    @Override
    @Transactional
    public void flush() {
        gameRepository.flush();
    }
}
package com.restAPIremastered.service.impl;

import com.restAPIremastered.persistance.dto.RoundPlayerDTO;
import com.restAPIremastered.persistance.dto.ScorerDTO;
import com.restAPIremastered.persistance.entity.Player;
import com.restAPIremastered.persistance.repository.PlayerRepository;
import com.restAPIremastered.service.PlayerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerServiceImp implements PlayerService {
	private final PlayerRepository playerRepository;

	@Transactional
	@Override
	public void savePlayer(Player player) {

		playerRepository.save(player);
	}

	@Transactional
	@Override
	public List<Player> getPlayers() {

		return playerRepository.findAll();
	}

	@Transactional
	@Override
	public Player getPlayer(int theId) {

		Optional<Player> optionalPlayer = playerRepository.findById(theId);
		Player player = optionalPlayer.get();

		return player;
	}

	@Transactional
	@Override
	public void deletePlayer(int theId) {
		playerRepository.deleteById(theId);

	}

	@Transactional
	@Override
	public Player findPlayerByName(String firstName, String lastName) {

		Optional<Player> optionalPlayer = Optional.ofNullable(playerRepository.findPlayerByName(firstName, lastName));
		Player player = optionalPlayer.get();

		return player;
	}

	@Transactional
	@Override
	public List<RoundPlayerDTO> findRoundPlayersByRoundId(int roundId) {
		return playerRepository.findRoundPlayersByRoundId(roundId);
	}

	@Override
	public List<ScorerDTO> findPlayerScoresByRoundId(int roundId) {
		return playerRepository.findPlayerScoresByRoundId(roundId);
	}

}

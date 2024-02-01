package com.restAPIremastered.service;


import com.restAPIremastered.persistance.dto.RoundPlayerDTO;
import com.restAPIremastered.persistance.dto.ScorerDTO;
import com.restAPIremastered.persistance.entity.Player;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public interface PlayerService {

	public void savePlayer(Player player);

	public List<Player> getPlayers();

	public Player getPlayer(int theId);

	public void deletePlayer(int theId);

	public Player findPlayerByName(String firstName, String lastName);

	public List<RoundPlayerDTO> findRoundPlayersByRoundId(int roundId);

	public List<ScorerDTO> findPlayerScoresByRoundId(int roundId);
	public List<ScorerDTO> findOwnGoalsScorersByRoundId(int roundId);
}

package com.restAPIremastered.rest;

import com.restAPIremastered.persistance.dto.*;
import com.restAPIremastered.persistance.entity.*;
import com.restAPIremastered.service.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TheRestController {


    private final PlayerService playerService;
    private final RoundService roundService;
    private final TeamService2 teamService2;
    private final TeamPlayerService teamPlayerService;
    private final GameService gameService;
    private final GoalService goalService;


    @GetMapping("/players")
    public List<Player> getPlayers(){
        System.out.println("inside getPlayers");
        return playerService.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayer(@PathVariable int playerId){

        return playerService.getPlayer(playerId);
    }

    @DeleteMapping("/players/{playerId}")
    public String deletePlayer(@PathVariable int playerId){

        playerService.deletePlayer(playerId);

        return "The player with the id" + " " + playerId + " " + " was deleted";
    }

    @PutMapping("/players")
    public String updatePlayer(@RequestBody Player thePlayer){

        playerService.savePlayer(thePlayer);

        return "The player with the id " + " " + thePlayer.getId() +  " " + " was updated";
    }

    @PostMapping("/players")
    public String savePlayer(@RequestBody Player thePlayer){

        playerService.savePlayer(thePlayer);

        return "The player with the id " + " " + thePlayer.getId() +  " " + " was saved";
    }

    @GetMapping("/players/name")
    public Player findPlayerByName(@RequestParam String firstName, @RequestParam String lastName) {
        return playerService.findPlayerByName(firstName, lastName);
    }

    @GetMapping("/players/byRoundId/{roundId}")
    public List<RoundPlayerDTO> findPlayersByRoundId(@PathVariable int roundId){
        return this.playerService.findRoundPlayersByRoundId(roundId);
    }

    @GetMapping("/players/scorersByRoundId/{roundId}")
    public List<ScorerDTO> findScorersByRoundId(@PathVariable int roundId){
        return this.playerService.findPlayerScoresByRoundId(roundId);
    }

    @GetMapping("/players/ownGoalscorersByRoundId/{roundId}")
    public List<ScorerDTO> findOwnGoalScorersByRoundId(@PathVariable int roundId){
        return this.playerService.findOwnGoalsScorersByRoundId(roundId);
    }

    @GetMapping("/rounds")
    public List<RoundDTO> getRounds() {
        return roundService.getRounds();
    }

    @GetMapping("/rounds/{roundId}")
    public RoundDTO getRound(@PathVariable int roundId) {
        return roundService.getRound(roundId);
    }

    @GetMapping("/rounds/findByNumber/{roundNumber}")
    public RoundDTO getRoundByNumber(@PathVariable int roundNumber) {
        return roundService.findByRoundNumber(roundNumber);
    }

    @DeleteMapping("/rounds/{roundId}")
    @Transactional
    public String deleteRound(@PathVariable int roundId) {

        // Delete team players
        List<TeamPlayer> attendance = teamPlayerService.getTeamPlayerByRoundId(roundId);
        for (TeamPlayer tp : attendance) {
            teamPlayerService.deleteTeamPlayer(tp.getId());
            teamPlayerService.flush();
        }

        // Delete goals
        List<GoalDTO> goals = goalService.getGoalsByRoundId(roundId);
        for (GoalDTO goal : goals) {
            goalService.deleteGoal(goal.getId());
            goalService.flush();
        }

        // Delete games
        List<GameInfoDTO> games = gameService.getGamesByRoundId(roundId);
        for (GameInfoDTO game : games) {
            gameService.deleteGame(game.getGameId());
            gameService.flush();
        }

        // Delete teams
        List<TeamDTO> teams = teamService2.getTeamsByRoundId(roundId);
        for (TeamDTO team : teams) {
            teamService2.deleteTeam(team.getId());
            teamService2.flush();
        }

        // Delete the round
        roundService.deleteRound(roundId);

        return "The round with the id " + roundId + " was deleted";
    }

    @PutMapping("/rounds")
    public String updateRound(@RequestBody RoundDTO roundDTO) {
        roundService.saveRound(roundDTO);
        return "The round with the id " + roundDTO.getId() + " was updated";
    }

    @PostMapping("/rounds")
    public RoundDTO saveRound(@RequestBody RoundDTO roundDTO) {

        return roundService.saveRound(roundDTO);
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamDTO>> getTeams() {
        List<TeamDTO> teamDTO =  teamService2.getTeams();
        if (teamDTO != null) {
            return ResponseEntity.ok(teamDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO) {
        TeamDTO createdTeam = teamService2.createTeam(teamDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeam);
    }

    @GetMapping("/teams/{teamId}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable int teamId) {
        TeamDTO teamDTO = teamService2.getTeamById(teamId);
        if (teamDTO != null) {
            return ResponseEntity.ok(teamDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/teams/byRoundId/{roundId}")
    public List<TeamDTO> getTeamsByRoundId(@PathVariable int roundId) {
        return teamService2.getTeamsByRoundId(roundId);
    }
    @DeleteMapping("/teams/{teamId}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int teamId) {
        teamService2.deleteTeam(teamId);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/team-players")
    public List<TeamPlayerDTO> getTeamPlayers() {
        return teamPlayerService.getTeamPlayers();
    }

    @GetMapping("/team-players/{teamPlayerId}")
    public TeamPlayerDTO getTeamPlayer(@PathVariable int teamPlayerId) {
        return teamPlayerService.getTeamPlayer(teamPlayerId);
    }

    @DeleteMapping("/team-players/{teamPlayerId}")
    public String deleteTeamPlayer(@PathVariable int teamPlayerId) {
        teamPlayerService.deleteTeamPlayer(teamPlayerId);
        return "The team player with the id " + teamPlayerId + " was deleted";
    }

    @PostMapping("/team-players")
    public String saveTeamPlayer(@RequestBody TeamPlayerDTO teamPlayerDTO) {
        teamPlayerService.saveTeamPlayer(teamPlayerDTO);
        return "The team player with the id " + teamPlayerDTO.getId() + " was saved";
    }

    @GetMapping("/team-players/byRoundId/{roundId}")
    public List<TeamPlayer> getTeamPlayerByRoundId(@PathVariable int roundId){
        return this.teamPlayerService.getTeamPlayerByRoundId(roundId);
    }

    @GetMapping("/games")
    public List<GameDTO> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable int gameId) {
        return gameService.getGame(gameId);
    }

    @GetMapping("/games/byRoundId/{roundId}")
    public List<GameInfoDTO> getGamesByRoundNr(@PathVariable int roundId){
        return gameService.getGamesByRoundId(roundId);
    }

    @DeleteMapping("/games/{gameId}")
    public String deleteGame(@PathVariable int gameId) {
        gameService.deleteGame(gameId);
        return "The game with the id " + gameId + " was deleted";
    }

    @PostMapping("/games")
    public GameDTO saveGame(@RequestBody GameDTO gameDTO) {

        return gameService.saveGame(gameDTO);
    }

    @GetMapping("/goals")
    public List<GoalDTO> getGoals() {
        return goalService.getGoals();
    }

    @GetMapping("/goals/{goalId}")
    public GoalDTO getGoal(@PathVariable int goalId) {
        return goalService.getGoal(goalId);
    }

    @DeleteMapping("/goals/{goalId}")
    public String deleteGoal(@PathVariable int goalId) {
        goalService.deleteGoal(goalId);
        return "The goal with the id " + goalId + " was deleted";
    }

    @PostMapping("/goals")
    public String saveGoal(@RequestBody GoalDTO goalDTO) {
        goalService.saveGoal(goalDTO);
        return "The goal with the id " + goalDTO.getId() + " was saved";
    }

    @GetMapping("/goals/byRoundId/{roundId}")
    public List<GoalDTO> getGoalsByRoundId(@PathVariable int roundId) {
        return goalService.getGoalsByRoundId(roundId);
    }

}



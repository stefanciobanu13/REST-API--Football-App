package com.restAPIremastered.persistance.dto;

public class GoalDTO {

    private int id;
    private int gameId;
    private int playerId;
    private int teamId;
    private boolean ownGoal;

    // Constructors, getters, and setters

    public GoalDTO() {}

    public GoalDTO(int id, int gameId, int playerId) {
        this.id = id;
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public GoalDTO(int id, int gameId, int playerId, int teamId) {
        this.id = id;
        this.gameId = gameId;
        this.playerId = playerId;
        this.teamId = teamId;
    }

    public GoalDTO(int id, int gameId, int playerId, int teamId, boolean ownGoal ) {
        this.id = id;
        this.gameId = gameId;
        this.playerId = playerId;
        this.ownGoal = ownGoal;
    }


    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean isOwnGoal() {
        return ownGoal;
    }

    public void setOwnGoal(boolean ownGoal) {
        this.ownGoal = ownGoal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
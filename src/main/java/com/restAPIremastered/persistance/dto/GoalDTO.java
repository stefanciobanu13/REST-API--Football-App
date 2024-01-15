package com.restAPIremastered.persistance.dto;

public class GoalDTO {

    private int id;
    private int gameId;
    private int playerId;

    // Constructors, getters, and setters

    public GoalDTO() {}

    public GoalDTO(int id, int gameId, int playerId) {
        this.id = id;
        this.gameId = gameId;
        this.playerId = playerId;
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
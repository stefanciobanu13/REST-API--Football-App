package com.restAPIremastered.persistance.dto;

public class RoundPlayerDTO {
    private String playerName;
    private String teamColor;

    public RoundPlayerDTO(String playerName, String teamColor) {
        this.playerName = playerName;
        this.teamColor = teamColor;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
}
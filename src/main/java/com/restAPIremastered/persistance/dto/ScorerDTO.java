package com.restAPIremastered.persistance.dto;

public class ScorerDTO {

    private String playerName;
    private int matchNumber;
    private String teamColor;
    private long numberOfGoals;

    public ScorerDTO(String playerName, int matchNumber, String teamColor, long numberOfGoals) {
        this.playerName = playerName;
        this.matchNumber = matchNumber;
        this.teamColor = teamColor;
        this.numberOfGoals = numberOfGoals;
    }

    // Getter methods (and optionally setter methods) go here

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public String getTeamColor() {
        return teamColor;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public long getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setNumberOfGoals(int numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }

}
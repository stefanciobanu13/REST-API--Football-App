package com.restAPIremastered.persistance.dto;

public class ScorerDTO {

    private String playerName;
    private int matchNumber;
    private long numberOfGoals;

    public ScorerDTO(String playerName, int matchNumber, long numberOfGoals) {
        this.playerName = playerName;
        this.matchNumber = matchNumber;
        this.numberOfGoals = numberOfGoals;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public long getNumberOfGoals() {
        return numberOfGoals;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setMatchNumber(int matchNumber) {
        this.matchNumber = matchNumber;
    }

    public void setNumberOfGoals(long numberOfGoals) {
        this.numberOfGoals = numberOfGoals;
    }


}

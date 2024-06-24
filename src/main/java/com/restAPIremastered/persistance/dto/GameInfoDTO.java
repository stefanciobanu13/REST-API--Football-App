package com.restAPIremastered.persistance.dto;

public class GameInfoDTO {

    private int gameId;
    private String team1Color;
    private String team2Color;
    private int team1Goals;
    private int team2Goals;

    public GameInfoDTO(int gameId, String team1Color, String team2Color, int team1Goals, int team2Goals) {
        this.gameId = gameId;
        this.team1Color = team1Color;
        this.team2Color = team2Color;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
    }


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTeam1Color() {
        return team1Color;
    }

    public void setTeam1Color(String team1Color) {
        this.team1Color = team1Color;
    }

    public String getTeam2Color() {
        return team2Color;
    }

    public void setTeam2Color(String team2Color) {
        this.team2Color = team2Color;
    }

    public int getTeam1Goals() {
        return team1Goals;
    }

    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }

    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }

    @Override
    public String toString() {
        return "GameInfoDTO{" +
                "gameId=" + gameId +
                ", team1Color='" + team1Color + '\'' +
                ", team2Color='" + team2Color + '\'' +
                ", team1Goals=" + team1Goals +
                ", team2Goals=" + team2Goals +
                '}';
    }
}

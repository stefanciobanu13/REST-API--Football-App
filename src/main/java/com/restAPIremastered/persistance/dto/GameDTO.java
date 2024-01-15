package com.restAPIremastered.persistance.dto;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
public class GameDTO {

    private int id;
    private int team1Id;
    private int team2Id;
    private int roundId;
    private int team1Goals;
    private int team2Goals;
    private int number;

    // Constructors, getters, setters


    public GameDTO() {

    }

    public GameDTO(int id, int team1Id, int team2Id, int roundId, int team1Goals, int team2Goals, int number) {
        this.id = id;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
        this.roundId = roundId;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(int team1Id) {
        this.team1Id = team1Id;
    }

    public int getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(int team2Id) {
        this.team2Id = team2Id;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
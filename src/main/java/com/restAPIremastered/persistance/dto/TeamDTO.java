package com.restAPIremastered.persistance.dto;

public class TeamDTO {

    private int id;
    private String color;
    private int points;
    private int goalRate;

    private int roundId;


    // Constructors, getters, setters

    // Constructors
    public TeamDTO() {
    }

    public TeamDTO(int id, String color, int points, int goalRate,int roundId) {
        this.id = id;
        this.color = color;
        this.points = points;
        this.goalRate = goalRate;
        this.roundId =roundId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalRate() {
        return goalRate;
    }

    public void setGoalRate(int goalRate) {
        this.goalRate = goalRate;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }
}
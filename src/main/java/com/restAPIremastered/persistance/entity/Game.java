package com.restAPIremastered.persistance.entity;


import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Table(name ="game")
@Entity
@Component
@ToString
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team1_id")
    private Team team1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team2_id")
    private Team team2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "round_id")
    private Round round;

    @Column(name = "team1_goals")
    private int team1Goals;

    @Column(name = "team2_goals")
    private int team2Goals;

    @Column(name = "number")
    private int number;

    //constructors
    public Game(){}

    public Game(int id, int number, Team team1, Team team2, Round round, int team1Goals, int team2Goals) {
        this.id = id;
        this.number = number;
        this.team1 = team1;
        this.team2 = team2;
        this.round = round;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
    }

    public Game(Team team1, Team team2, int team1Goals, int team2Goals, Round round, int number) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.round = round;
        this.number= number;
    }

    public Game(Team team1, Team team2, Round round){
        this.team1 = team1;
        this.team2 = team2;
        this.round = round;
    }


    //getters and setters


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTeam1Goals() {
        return team1Goals;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public int getTeam2Goals() {
        return team2Goals;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeam1Goals(int team1Goals) {
        this.team1Goals = team1Goals;
    }

    public void setTeam2Goals(int team2Goals) {
        this.team2Goals = team2Goals;
    }

}

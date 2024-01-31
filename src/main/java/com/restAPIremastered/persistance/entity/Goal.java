package com.restAPIremastered.persistance.entity;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;



@Entity
@Component
@Table(name = "goal")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Game game;

//  @Transient
//    private Team team;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "own_goal")
    private boolean ownGoal;

    //constructors

    public Goal(){}

    public Goal(int id, Game game, Team team, Player player) {
        this.id = id;
        this.game = game;
        this.team = team;
        this.player = player;
    }


    public Goal(Game game, Team team, Player player) {
        this.game = game;
        this.team = team;
        this.player = player;
    }

    public Goal(Game game, Player player) {
        this.game = game;
        this.player = player;
    }


    //getters and setters

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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}

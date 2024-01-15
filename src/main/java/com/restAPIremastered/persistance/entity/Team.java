package com.restAPIremastered.persistance.entity;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;



@Entity
@Component
@Table(name = "team")
public class Team {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "color")
	private String color;

	@Column(name = "points")
	private int points;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "round_id")
	private Round round;

	@Column(name = "goal_rate")
	private int goalRate;

	//constructors
	public Team() {
	}


	public Team( int id, String color, Round round) {
		this.id = id;
		this.color = color;
		this.round = round;
	}

	public Team(String color){
		this.color=color;
	}


	//getters and setters
	public int getGoalRate() {
		return goalRate;
	}

	public void setGoalRate(int goalRate) {
		this.goalRate = goalRate;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//Getter and setters for colour
	public void setColor(String colour){

		this.color =colour;
	}

	public String getColor(){

		return this.color;
	}




}


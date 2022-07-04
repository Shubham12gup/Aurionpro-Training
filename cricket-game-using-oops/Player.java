package com.aurionpro.model;

public class Player {
	String name;
	int turns;
	int score = 0;

	public Player(String name) {
		this.name = name;
		this.turns = turns;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turns) {
		this.turns = turns;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

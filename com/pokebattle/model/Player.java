package com.pokebattle.model;

public class Player {

	private String name ;
	private int Medals;
	private int goldenSand ;
	private int goldenChip;


	//constructors
	public Player(String name, int Medals, int goldenSand, int goldenChip) {
		this.name = name;
		this.Medals = Medals;
		this.goldenSand = goldenSand;
		this.goldenChip = goldenChip;
	}

	//setter getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMedals() {
		return Medals;
	}

	public void setMedals(int Medals) {
		this.Medals = Medals;
	}

	public int getGoldenSand() {
		return goldenSand;
	}

	public void setGoldenSand(int goldenSand) {
		this.goldenSand = goldenSand;
	}

	public int getGoldenChip() {
		return goldenChip;
	}

	public void setGoldenChip(int goldenChip) {
		this.goldenChip = goldenChip;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", Medals=" + Medals + ", goldenSand=" + goldenSand + ", goldenChip="
				+ goldenChip + "]";
	}
	
	
	
	 
	
}




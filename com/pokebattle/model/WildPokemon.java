package com.pokebattle.model;

public class WildPokemon extends Pokemon {
	
	// Attributes
	private String PokemonType;

	// Constructor
	public WildPokemon(String name, String defendType, String attackType, int power, double hp, String PokemonType) {
		super(name, defendType, attackType, power, hp);
		this.PokemonType = PokemonType;
	}
	
	// Getters
	public String getPokemonType() {
		return PokemonType;
	}

	// Setters
	public void setPokemonType(String PokemonType) {
		this.PokemonType = PokemonType;
	}
	
	// Methods
	@Override
    public String battleCry() {
        return name + " roars: 'I am a wild Pokémon!'";
    }
	
	// To string Override
	@Override
	public String toString() {
		return "Wild " + super.toString() + "\n     PokemonType: " + PokemonType;
	}
}
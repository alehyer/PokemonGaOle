package com.pokebattle.battle;

import com.pokebattle.model.*;

public class Battle {

	private static final double[][] EFFECTIVENESS_CHART = {
		        {1, 1, 0.5, 1, 2, 0.5}, // ICE
		        {1, 0.5, 1, 2, 1, 1},   // DARK
		        {2, 1, 0.5, 1, 0.5, 1}, // WATER
		        {1, 0.5, 1, 1, 1, 2},   // FAIRY
		        {0.5, 1, 2, 1, 1, 0.5}, // GRASS
		        {2, 1, 0.5, 0.5, 1, 0.5} // STEEL
		    };
	 
	private static double PlayerScore ; 
	private static  double OpponentScore ;
	
	public double getPlayerscore() {
		return PlayerScore;
	}

	public double getOpponentscore() {
		return OpponentScore;
	}

    public boolean startBattle(Pokemon playerPokemon, WildPokemon opponentPokemon) {
        System.out.println("Battle begins between " + playerPokemon.getName() + " and " + opponentPokemon.getName() + "!");
        
        while (playerPokemon.getHp() > 0 && opponentPokemon.getHp() > 0) {
            // Player attacks opponent
            double playerAttackEffectiveness = calculateEffectiveness(playerPokemon.getAttack(), opponentPokemon.getDefend());
            double playerDamage = playerPokemon.getPower() * playerAttackEffectiveness;
            opponentPokemon.setHp(opponentPokemon.getHp() - playerDamage);
            System.out.println("\n" + playerPokemon.getName() + " attacks for " + playerDamage + " damage!\nEnemy HP: " + opponentPokemon.getHp());    
    
            if (opponentPokemon.getHp() <= 0) {
                System.out.println("\n" + opponentPokemon.getName() + " is defeated! Player wins!");
                PlayerScore = playerDamage;
                return true;  // Player wins, return true
            }
            
            // Opponent attacks player
            double opponentAttackEffectiveness = calculateEffectiveness(opponentPokemon.getAttack(), playerPokemon.getDefend());
            double opponentDamage = opponentPokemon.getPower() * opponentAttackEffectiveness;
            playerPokemon.setHp(playerPokemon.getHp() - opponentDamage);
            System.out.println("\n" + opponentPokemon.getName() + " attacks for " + opponentDamage + " damage\nPlayer HP: " + playerPokemon.getHp());
    
            if (playerPokemon.getHp() <= 0) {
                System.out.println("\n" + playerPokemon.getName() + " is defeated! Enemy wins!");
                OpponentScore = opponentDamage;
                return false;  // Opponent wins, return false
            }
        }
        return false;  // In case of some other error (e.g., no winner)
    }

	private double calculateEffectiveness(String attackerType, String defenderType) {
        int attackerIndex = getTypeIndex(attackerType);
        int defenderIndex = getTypeIndex(defenderType);
        if (attackerIndex == -1 || defenderIndex == -1) {
            return 1; // Neutral damage if the types are invalid
        }
        return EFFECTIVENESS_CHART[attackerIndex][defenderIndex];
    }
	
	private int getTypeIndex(String type) {
        switch (type.toUpperCase()) {
            case "ICE": return 0;
            case "DARK": return 1;
            case "WATER": return 2;
            case "FAIRY": return 3;
            case "GRASS": return 4;
            case "STEEL": return 5;
            default: return -1;
        }
    }

}
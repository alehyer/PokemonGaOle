package com.pokebattle.game;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import com.pokebattle.model.*;
import com.pokebattle.battle.*;

public class Game {

	//Method
	public void StartGame(){
        Scanner input = new Scanner(System.in);

    	System.out.println("\nEnter your name below!\n");
    	String name = input.nextLine();
    	
    	Player player1 = new Player("",0,0,0);
    	player1.setName(name);
    	
    	System.out.println("\n=========================================\n\nWELCOME TO POKEMON GA-OLE, " + player1.getName() + "!");
    
        ArrayList<Pokemon> NormalPokemons = new ArrayList<>();
     
        NormalPokemons.add(new Pokemon("Clefairy", "Fairy", "Dark", 45, 89.0)); 
        NormalPokemons.add(new Pokemon("Leafeon", "Grass", "Ice", 43, 78.0));
        NormalPokemons.add(new Pokemon("Azumarill", "Fairy", "Water", 76, 90.0));
        NormalPokemons.add(new Pokemon("Magnezone", "Steel", "Ice", 34, 67.0));
        NormalPokemons.add(new Pokemon("Glaceon", "Ice", "Fairy", 67, 74.0));
        NormalPokemons.add(new Pokemon("Togekiss", "Steel", "Fairy", 89, 81.0));
        NormalPokemons.add(new Pokemon("Sylveon", "Fairy", "Fairy", 78, 69.0));
        NormalPokemons.add(new Pokemon("Ludicolo", "Water", "Grass", 65, 88.0));
        NormalPokemons.add(new Pokemon("Metagross", "Steel", "Steel", 71, 65.0));
        NormalPokemons.add(new Pokemon("Umbreon", "Fairy", "Dark", 56, 65.0));
        NormalPokemons.add(new Pokemon("Weavile", "Dark", "Ice", 78, 87.0));

        //Pokemon that will likely appear in the game.
        Collections.shuffle(NormalPokemons);
        Pokemon Possiblepokemon1 = NormalPokemons.get(3);
        Pokemon Possiblepokemon2 = NormalPokemons.get(7);
        Pokemon Possiblepokemon3 = NormalPokemons.get(9);
        
        System.out.println("\n-----------------------------------------\nThese enemy pokemons might appear in your game: ");
        System.out.println(Possiblepokemon1.getName() +"\n"+ Possiblepokemon2.getName() +"\n"+ Possiblepokemon3.getName());
        
        Pokemon firstChoice = null;
        Pokemon secondChoice = null;

        int i = 0; 

        while (i < 2) { // Loop will run twice for first and second choice
           
        	//to get NormalPokemons
            Collections.shuffle(NormalPokemons);
            Pokemon normalPokemon1 = NormalPokemons.get(0);
            Pokemon normalPokemon2 = NormalPokemons.get(4);
            Pokemon normalPokemon3 = NormalPokemons.get(2);

            System.out.println("-----------------------------------------\nHere are the pokemons you can choose from:\n");
            System.out.println(" Pokemon 1: " + normalPokemon1);
            System.out.println(" Pokemon 2: " + normalPokemon2);
            System.out.println(" Pokemon 3: " + normalPokemon3);

            // User to select one Pokémon
            boolean validChoice = false; // To track if the choice is valid
            do {
                System.out.print("\n \033[1m  Select a Pokemon (1, 2, or 3): \033[0m");
                String playerChoice = input.nextLine();

                if (playerChoice.equals("1")) {
                    if (i == 0) {
                        firstChoice = normalPokemon1; // Save first choice
                    } else {
                        secondChoice = normalPokemon1; // Save second choice
                    }
                    validChoice = true;
                } else if (playerChoice.equals("2")) {
                    if (i == 0) {
                        firstChoice = normalPokemon2;
                    } else {
                        secondChoice = normalPokemon2;
                    }
                    validChoice = true;
                } else if (playerChoice.equals("3")) {
                    if (i == 0) {
                        firstChoice = normalPokemon3;
                    } else {
                        secondChoice = normalPokemon3;
                    }
                    validChoice = true;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } while (!validChoice); // This is to Repeat until a valid choice is entered

            i++; 
        }

        //to display wild pokemons
        ArrayList<WildPokemon> wildPokemons = new ArrayList<>();
        
        wildPokemons.add(new WildPokemon("Bulbasaur", "Grass", "Water", 79, 67.0, "Common"));
        wildPokemons.add(new WildPokemon("Primarina", "Fairy", "Water", 80, 88.0, "Rare"));
        wildPokemons.add(new WildPokemon("Jirachi", "Steel", "Ice", 76, 97.0, "Rare"));
        wildPokemons.add(new WildPokemon("Mawile", "Steel", "Dark", 70, 71.0, "Common"));
        wildPokemons.add(new WildPokemon("Zacian", "Fairy", "Dark", 76, 89.0, "Legend"));
        wildPokemons.add(new WildPokemon("Bisharp", "Dark", "Steel", 70, 56.0, "Rare"));
        wildPokemons.add(new WildPokemon("Magearna", "Steel", "Fairy", 21, 87.0, "Rare"));
        wildPokemons.add(new WildPokemon("Diancie", "Fairy", "Steel", 76, 88.0, "Legend"));
        wildPokemons.add(new WildPokemon("Tapu Fini", "Water", "Fairy", 87, 87.0, "Rare"));
        wildPokemons.add(new WildPokemon("Grimmsnarl", "Dark", "Fairy", 54, 78.0, "Common"));
      
        //to get random wildPokemons        
        Collections.shuffle(wildPokemons);
        WildPokemon wildPokemon1 = wildPokemons.get(3);
        WildPokemon wildPokemon2 = wildPokemons.get(7);
        
        System.out.println("\n\033[1m--------------SEE YOUR ENEMIES------------\033[0m \n\nPRESS ENTER");
        String ShowWildPokemons = input.nextLine();
        
        System.out.println("\n=======================================\n");
        System.out.println("You will be facing these Wild Pokemons: \n");
        System.out.println(wildPokemon1 +"\n"+ wildPokemon2);
        System.out.println("\n=======================================\n");

        //BattleDetails
        System.out.println("PRESS ENTER");
        String BattleDetails = input.nextLine();
        
        System.out.println("\n\033[1m------------Your Pokemons------------\033[0m \n");
        System.out.println("1 - " + firstChoice);
        System.out.println("2 - " + secondChoice);
        
        System.out.println("\n\033[1m------------Enemy Pokemons------------\033[0m \n");
        System.out.println("1 - " + wildPokemon1);
        System.out.println("2 - " + wildPokemon2);
        
       
        //MainBattle
       
     // Input for the first battle pokemon
        System.out.println("\n-----------------------------------------\nChoose a pokemon for the first battle, your other pokemon will be used in the second battle.\n(Enter '1' or '2'): ");
        String firstBattlePokemon = input.nextLine().trim();
        while (!firstBattlePokemon.equals("1") && !firstBattlePokemon.equals("2")) {
            System.out.println("\nInvalid choice. Please enter '1' or '2': ");
            firstBattlePokemon = input.nextLine().trim();
        }

        // Input for the first battle wild pokemon
        System.out.println("\nWhich wild pokemon do you want to battle (Enter '1' or '2'): ");
        String firstBattleWildPokemon = input.nextLine().trim();
        while (!firstBattleWildPokemon.equals("1") && !firstBattleWildPokemon.equals("2")) {
            System.out.println("\nInvalid choice. Please enter '1' or '2': ");
            firstBattleWildPokemon = input.nextLine().trim();
        }

        System.out.println("\n=========================================");
        System.out.println("LET THE FIRST BATTLE BEGIN\n");


        Battle battle1 = new Battle();
        boolean firstBattleWon = false;

        // First battle logic 
        System.out.println(firstChoice.battleCry());
        if (firstBattlePokemon.equals("1") && firstBattleWildPokemon.equals("1")) {
            battle1.startBattle(firstChoice, wildPokemon1);
            firstBattleWon = wildPokemon1.getHp() <= 0; // Check if wildPokemon1 is defeated
        } else if (firstBattlePokemon.equals("1") && firstBattleWildPokemon.equals("2")) {
            battle1.startBattle(firstChoice, wildPokemon2);
            firstBattleWon = wildPokemon2.getHp() <= 0; // Check if wildPokemon2 is defeated
        } else if (firstBattlePokemon.equals("2") && firstBattleWildPokemon.equals("1")) {
            battle1.startBattle(secondChoice, wildPokemon1);
            firstBattleWon = wildPokemon1.getHp() <= 0; // Check if wildPokemon1 is defeated
        } else if (firstBattlePokemon.equals("2") && firstBattleWildPokemon.equals("2")) {
            battle1.startBattle(secondChoice, wildPokemon2);
            firstBattleWon = wildPokemon2.getHp() <= 0; // Check if wildPokemon2 is defeated
        }

        System.out.println("\n=========================================");
        System.out.println("LET THE SECOND BATTLE BEGIN\n");


        Battle battle2 = new Battle();
        boolean secondBattleWon = false;

        // Second battle logic
        if (firstBattlePokemon.equals("1")) {
            if (firstBattleWildPokemon.equals("1")) {
                battle2.startBattle(secondChoice, wildPokemon2);
                secondBattleWon = wildPokemon2.getHp() <= 0; // Check if wildPokemon2 is defeated
            } else {
                battle2.startBattle(secondChoice, wildPokemon1);
                secondBattleWon = wildPokemon1.getHp() <= 0; // Check if wildPokemon1 is defeated
            }
        } else {
            if (firstBattleWildPokemon.equals("1")) {
                battle2.startBattle(firstChoice, wildPokemon2);
                secondBattleWon = wildPokemon2.getHp() <= 0; // Check if wildPokemon2 is defeated
            } else {
                battle2.startBattle(firstChoice, wildPokemon1);
                secondBattleWon = wildPokemon1.getHp() <= 0; // Check if wildPokemon1 is defeated
            }
        }

        System.out.println("\n---------------Try To Catch The Pokemons---------------\n");

        Catch c = new Catch();

        // Determine which Pokemon can be caught based on battle outcomes
        if (firstBattleWon) {
            if (firstBattlePokemon.equals("1") && firstBattleWildPokemon.equals("1")) {
                System.out.println("\nYou defeated " + wildPokemon1.getName() + ", So you can catch the Pokémon");
                c.Catching(wildPokemon1, player1);
            } else if (firstBattlePokemon.equals("1") && firstBattleWildPokemon.equals("2")) {
                System.out.println("\nYou defeated " + wildPokemon2.getName() + ", So you can catch the Pokémon");
                c.Catching(wildPokemon2, player1);
            } else if (firstBattlePokemon.equals("2") && firstBattleWildPokemon.equals("1")) {
                System.out.println("\nYou defeated " + wildPokemon1.getName() + ", So you can catch the Pokémon");
                c.Catching(wildPokemon1, player1);
            } else if (firstBattlePokemon.equals("2") && firstBattleWildPokemon.equals("2")) {
                System.out.println("\nYou defeated " + wildPokemon2.getName() + ", So you can catch the Pokémon");
                c.Catching(wildPokemon2, player1);
            }
        } else {
            System.out.println("\nYou lost the first battle, so you cannot catch the Pokémon.");
        }

        if (secondBattleWon) {
            if (firstBattlePokemon.equals("1")) {
                if (firstBattleWildPokemon.equals("1")) {
                    System.out.println("\nYou defeated " + wildPokemon2.getName() + ", So you can catch the Pokémon");
                    c.Catching(wildPokemon2, player1);
                } else {
                    System.out.println("\nYou defeated " + wildPokemon1.getName() + ", So you can catch the Pokémon");
                    c.Catching(wildPokemon1, player1);
                }
            } else {
                if (firstBattleWildPokemon.equals("1")) {
                    System.out.println("\nYou defeated " + wildPokemon2.getName() + ", So you can catch the Pokémon");
                    c.Catching(wildPokemon2, player1);
                } else {
                    System.out.println("\nYou defeated " + wildPokemon1.getName() + ", So you can catch the Pokémon");
                    c.Catching(wildPokemon1, player1);
                }
            }
        } else {
            System.out.println("\nYou lost the second battle, so you cannot catch the Pokémon.");
        }

        
        //CalculatingScore
        System.out.println("\n-----------------------------------------");
        
        Battle BattleScore = new Battle();
        System.out.println("\nPlayer Score: " + BattleScore.getPlayerscore());
        System.out.println("\nOpponent Score: " + BattleScore.getOpponentscore());

        String filePath = "ScoreList.txt";

        try (FileWriter writer = new FileWriter(filePath, true)) { 
            writer.write(name + " - " + BattleScore.getPlayerscore() + "\n");
            System.out.println("\nPlayer score saved successfully! Check ScoreList.txt!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the score: " + e.getMessage());
        }
        input.close();
	}
}
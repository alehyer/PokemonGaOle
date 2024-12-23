package com.pokebattle.battle;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import com.pokebattle.model.*;

public class Catch {
    private static final Set<String> VALID_BALLS = new HashSet<>();
    
    static {
        VALID_BALLS.add("pokeball");
        VALID_BALLS.add("greatball");
        VALID_BALLS.add("ultraball");
        VALID_BALLS.add("masterball");
    }

    private Scanner input = new Scanner(System.in);

    public void Catching(WildPokemon wildPokemon, Player player) {
        String userBall = getValidBall();

        // Calculate catching probability
        int pokeballCatch = wildPokemon.getPower() - poking(wildPokemon);
        int goldenSand = 0, goldenChip = 0;

        // Assign golden sand and chips based on the ball used
        switch (userBall) {
            case "pokeball":
                goldenSand = 3;
                goldenChip = 1;
                break;
            case "greatball":
                goldenSand = 4;
                goldenChip = 2;
                break;
            case "ultraball":
                goldenSand = 6;
                goldenChip = 3;
                break;
            case "masterball":
                goldenSand = 6;
                goldenChip = 6;
                break;
        }

        // Determine success of catching the Pokémon
        if (isSuccessfulCatch(pokeballCatch, userBall)) {
            System.out.println("\nYou Caught the Pokémon!");
            System.out.printf("\nOh! The wild Pokémon dropped %d golden sand and %d golden chips.%n",
                    goldenSand, goldenChip);
            player.setGoldenSand(goldenSand);
            player.setGoldenChip(goldenChip);
        } else {
            System.out.println("\nYou didn't catch the Pokémon.");
        }

        // Convert to golden medals
        int totalMedals = player.getGoldenSand() + player.getGoldenChip();
        player.setMedals(totalMedals);

        System.out.println("\nGolden Sand and Golden Chips converted to Medals.\nYour Medals = " + player.getMedals());

        // Check for free gift
        handleFreeGift(player);
    }

    // Get a valid ball from the user
    private String getValidBall() {
        String userBall;
        while (true) {
            System.out.println("\nChoose a Ball to catch the Wild Pokemon! \n[pokeball, greatball, ultraball, masterball]:\n");
            userBall = input.nextLine().trim().toLowerCase();

            if (VALID_BALLS.contains(userBall)) {
                return userBall;
            } else {
                System.out.println("\nInvalid choice! Please choose a valid ball.");
            }
        }
    }

    // Check if the ball was a successful catch
    private boolean isSuccessfulCatch(int pokeballCatch, String ball) {
        int threshold = 0;

        // Determine threshold based on the ball type
        switch (ball) {
            case "pokeball":
                threshold = 60;
                break;
            case "greatball":
                threshold = 50;
                break;
            case "ultraball":
                threshold = 35;
                break;
            case "masterball":
                threshold = 25;
                break;
        }

        return pokeballCatch > threshold;
    }

    // Add-on feature: Handle free gifts based on medals
    private void handleFreeGift(Player player) {
        int medals = player.getMedals();
        String userChoice;

        // Ask the player if they want the gift
        while (true) {
            System.out.println("\n\nDo you want to receive a gift with your Golden Medals? (Y/N): ");
            userChoice = input.nextLine().trim().toUpperCase();

            if (userChoice.equals("Y")) {
                // Process the gift based on golden medals
                int giftAmount = 0;
                if (medals >= 5 && medals <= 6) {
                    giftAmount = 3;
                } else if (medals >= 7 && medals <= 9) {
                    giftAmount = 5;
                } else if (medals >= 10 && medals <= 12) {
                    giftAmount = 7;
                }

                if (giftAmount > 0) {
                    System.out.println("\nGIFT: SURPRISE! YOU GET EXTRA " + giftAmount + " GOLDEN MEDALS");
                    player.setMedals(medals + giftAmount);
                } else {
                    System.out.println("\nSorry, you don't have enough Golden Medals to receive a gift.");
                }
                break;
            } else if (userChoice.equals("N")) {
                System.out.println("\nYou chose not to receive a gift. Proceeding...");
                break;
            } else {
                System.out.println("\nInvalid input! Please enter 'Y' for Yes or 'N' for No.");
            }
        }

        // Display the final golden medal count
        System.out.println("\nYour total Golden Medals: " + player.getMedals());
    }

    // Calculate the catch difficulty based on the Pokémon type
    public int poking(WildPokemon wp) {
        switch (wp.getPokemonType().toLowerCase()) {
            case "common":
                return 30;
            case "rare":
                return 20;
            case "legend":
                return 10;
            default:
                return 0;
        }
    }
}
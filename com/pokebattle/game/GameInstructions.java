package com.pokebattle.game;

public class GameInstructions {

    public static void printInstructions() {
        String[] instructions = {
            "--------------INSTRUCTIONS--------------\n",
            "\n1. [1mEnter Your Name[0m\n   - At the beginning of the game, you will be prompted to enter your name.\n",
            "\n2. [1mChoose Your Pokémon Team[0m\n   - You will be shown a list of three random Pokémon.\n   - Select one Pokémon for your FIRST choice and another for your SECOND choice.\n   - Enter the respective number (e.g., '1', '2', or '3').\n",
            "\n3. [1mView Your Enemies (Wild Pokémon)[0m\n   - Press 'W' to reveal the two Wild Pokémon you will battle.\n   - Each Wild Pokémon has unique stats such as attack, defense, power, and HP.\n",
            "\n4. [1mBattle Setup[0m\n   - Choose one Pokémon from your team to face one of the Wild Pokémon.\n     * Enter '1' or '2' to select your Pokémon.\n     * Enter '1' or '2' to choose a Wild Pokémon to battle.\n",
            "\n5. [1mBattle Mechanics[0m\n   - Battles begin between your chosen Pokémon and the Wild Pokémon.\n   - Each Pokémon attacks in turns.\n   - The battle ends when one Pokémon's HP reaches zero.\n",
            "\n6. [1mSecond Battle[0m\n   - If your first Pokémon is defeated, the second battle begins automatically.\n   - The second battle will use the Pokémon you didn’t choose for the first round.\n",
            "\n7. [1mCatching Wild Pokémon and Earning Free Gifts[0m\n   - After defeating a Wild Pokémon, you can attempt to catch it.\n   - If your Pokémon loses the battle, you cannot catch that Wild Pokémon.\n   - To catch a Pokémon, choose a Pokéball (e.g., 'pokeball', 'greatball', 'ultraball', or 'masterball').\n   - The success of catching depends on the ball chosen and the calculations behind it.\n   - If you succeed in catching any wild Pokémon, you will be able to earn golden medals to get free gifts.\n",
            "\n8. [1mScoring System[0m\n   - After the battles, scores for you and your opponent will be displayed.\n   - Your score is saved automatically for future reference.\n   - Check the 'TopScoreList' file to view your scores.\n",
            "\n[1m==GOOD LUCK! LET THE GAME BEGIN!==[0m\n"
        };

        System.out.println("\n========================================");
        for (String instruction : instructions) {
            System.out.print(instruction);
        }
        System.out.println("\n========================================");
    }
}
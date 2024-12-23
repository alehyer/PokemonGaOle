import src.com.pokebattle.game.*;

public class run {
	public static void main(String[] args) {
		GameInstructions.printInstructions();

		// Running the game
		Game PokemonGame = new Game();
		PokemonGame.StartGame();
	}	
}		
import com.pokebattle.game.*;

public class run {
	public static void main(String[] args) {
		GameInstructions.printInstructions();

		// Running an instance of the game
		Game PokemonGame = new Game();
		PokemonGame.StartGame();
		
	}	
}



		
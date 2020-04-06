package connect4Game;
import java.util.Scanner;

public class Connect4Game {
	public ConnectPlayer firstPlayer;
	public ConnectPlayer secondPlayer;
	public Connect4Grid grid; // an interface called grid
	
	Connect4Game(String playerTwo)
	{
		//DEFAULTS :
		grid = new Connect4Grid2DArray(); //make a new grid.
		this.firstPlayer = new C4HumanPlayer(); //make a new human player as default.
		
		//CONDITINALS :
		if(playerTwo.equalsIgnoreCase("human")) {
			this.secondPlayer = new C4HumanPlayer(); //make a new human player
		}
		
		else if(playerTwo.equalsIgnoreCase("Computer")) {
			this.secondPlayer = new C4RandomAIPlayer(); //make a new computer player
		}
		
		else if(playerTwo.equalsIgnoreCase("Random Player AI")) {
			this.secondPlayer = new C4RandomAIPlayer(); //make a new computer player
			
		}
		else {
			System.out.println("INVALID INPUT, TRY AGAIN.");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Do you want to play with another human or a computer (Random Player AI) ;");
		String input = scanner.nextLine();
		
		Connect4Game newGame = new Connect4Game(input); //make a new game
		
		newGame.grid.emptyGrid(); //empty the grid first.
		
		newGame.firstPlayer.setPlayer(1); //set the first player by passing 1 into the function setPlayer
		
		newGame.secondPlayer.setPlayer(2); //set the second player by passing 2 into the function setPlayer
		
		newGame.firstPlayer.setPlayerPiece(); // set the first player's piece
		
		newGame.secondPlayer.setPlayerPiece(); // set the second player's piece
		
		ConnectPlayer currentPlayer = newGame.firstPlayer; //make the first player start the game
		System.out.println(newGame.grid.toString()); //print out the output for the user
		
		while(!newGame.grid.isGridFull() && !newGame.grid.didLastPieceConnect4()) 
		{
			String output = "";
			if (currentPlayer.equals(newGame.firstPlayer)) {
				output = "Player One's Turn ; ";
			}
			else {
				output = "Player Two's Turn ; ";
			}
			System.out.println(output + "\n-------------");
			
			if(currentPlayer.equals(newGame.firstPlayer))
			{
				newGame.firstPlayer.makeMove(newGame.grid, newGame.firstPlayer); //the player can make a move
				currentPlayer = newGame.secondPlayer; //move onto the next player
			}
			else 
			{
				newGame.secondPlayer.makeMove(newGame.grid, newGame.secondPlayer); //the player can make a move
				currentPlayer = newGame.firstPlayer; //move back onto the first player
			}
			System.out.println(newGame.grid.toString()); //print out the grid and output again.
			
			if(newGame.grid.didLastPieceConnect4()) //if either of the users won.
			{
				//appropriate outputs for each scenario
				//NOTE: The outputs are reversed because after each move the current player automatically
				//      changes so we use the alternate for each scenario for it to work.
				if (currentPlayer.equals(newGame.firstPlayer))
				{
					System.out.println("Congratulations to the second player (human/AI) for winning!");
				}
				else {
					System.out.println("Congratulations to the first player for winning!");
				}
			}
		}
		scanner.close();
		
	}
}

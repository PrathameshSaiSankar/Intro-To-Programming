package connect4Game;
import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer{
	
	@Override
	public void makeMove(Connect4Grid grid, ConnectPlayer player) 
	{
		boolean done = false;
		while(!done)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter a column where you want to make a move : ");
			if(scanner.hasNextInt())
			{
				int column = scanner.nextInt();
				if(grid.isValidColumn(column)) //make sure it's a valid column first
				{
					grid.dropPiece(player, column); // let the human player make their move
					done = true;
				}
				else 
				{
					System.out.print("This column in INVALID!\n This time round, Please ");
				}
			}
			else
			{
				System.out.print("A column has to be an integer. Try Again\n This time round, Please ");
			}
		}
	}
}
package connect4Game;
import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer
{
	@Override
	public void makeMove(Connect4Grid grid, ConnectPlayer player) 
	{
		Random generator = new Random();
		boolean finished = false;
		while(!finished)
		{
			int randomColumn = generator.nextInt((7) + 1); //random number from 1 to 7 generated to check if it's a valid column.
			if(!grid.isColumnFull(randomColumn) && grid.isValidColumn(randomColumn) && randomColumn != 0)
			{
				//use that random column to drop a piece and make a move.
				grid.dropPiece(player, randomColumn);
				finished = true;
			}
		}
		
	}
}


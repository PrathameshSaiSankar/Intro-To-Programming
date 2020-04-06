package connect4Game;

public class Connect4Grid2DArray implements Connect4Grid {

	public void emptyGrid() 
	{
		//for loop to put an empty space into each place in the grid.
		for (int row = 0; row < grid.length; row++)  
		{
			for (int column = 0; column < grid[row].length; column++) 
			{
				grid[row][column] = ' '; 
			}
		}
	}

	public String toString() 
	{
		//String output for the user to play the game.
		String output = " Connect4Game!\n---------------\n|"; 
		for (int row = 0; row < grid.length; row++) 
		{
			for (int column = 0; column < grid[row].length; column++) 
			{
				if(column == 0) { 
					if (row > 0 && row < 6) {
						output = output +"\n|";
					}
			}
				output = output + grid[row][column] + "|";
		}
	}
		output = output + "\n---------------" + "\n" + " 1 2 3 4 5 6 7 ( <- columns)";
		return output;
			
	}

	public boolean isValidColumn(int column) 
	{
		//check if the number of columns are from 1 to 7
		if (column < 8 && column > 0) 
		{
			return true;
		} 
		else
			return false;
	}

	public boolean isColumnFull(int column) 
	{
		int amountFilled = 0;
		
		// check if the column passed into the function is 
		// filled with anything other than ' ' (i.e a blank space)
		for (int row = 0; row < 6; row++) 
		{
			if (grid[row][column] != ' ') 
			{
				amountFilled++;
			}
		}
		if (amountFilled == 6) 
		{
			return true;
		} 
		else {
			return false;
		}
	}
	
	public boolean isGridFull() 
	{
		int numberOfColumnsThatAreFull = 0;
		//loop through each column and check if it's full. If all columns full, then the whole grid is full.
		for (int column = 0; column < 7; column++) 
		{
			boolean columnFull = isColumnFull(column);
			if (columnFull) 
			{
				numberOfColumnsThatAreFull++;
			}
		}
		if (numberOfColumnsThatAreFull == 7) // i.e all columns are full
		{
			return true;
		} 
		else {
			return false;
		}
	}
	
	public void dropPiece(ConnectPlayer player, int column) 
	{
		boolean done = false;
		for (int row = (6 - 1); row >= 0 && !done; row--)  // 6-1 here is from the amount of rows - 1
		{
			if (grid[row][column - 1] == ' ') //make sure the place is empty first
			{
				grid[row][column - 1] = player.getPlayerPiece(); //drop the piece into the grid.
				done = true;
			}
		}
	}

	
	
	
	//CHECK IF ONE OF THE PLAYERS HAS WON USING THESE METHODS
	
	//METHOD 1:
	public boolean winHorizontally() 
	{

		   boolean won = false;
		for (int row = 0; row < grid.length && !won; row++) 
		{
			for (int column = 0; column < grid[row].length && !won; column++) 
			{
				//Get 4 elements adjacent to each other to test with on each column.
			 	int columnPlusOne = column + 1;
				int columnPlusTwo = column + 2;
				int columnPlusThree = column + 3;
				//make sure the 4 elements are not bigger than the whole length of the row since we cannot extend past the length of the grid.
				if (columnPlusOne < grid[row].length && columnPlusTwo < grid[row].length && columnPlusThree < grid[row].length) 
				{
					//if the four columns on the same row are not empty, then proceed to the next if statement
					if (grid[row][column] != ' ' && grid[row][columnPlusOne] != ' ' && grid[row][columnPlusTwo] != ' ' && grid[row][columnPlusThree] != ' ') 
					{
						//if the four columns on the same row are the same, then they won horizontally.
						if (grid[row][column] == grid[row][columnPlusThree] && grid[row][column] == grid[row][columnPlusTwo] && grid[row][column] == grid[row][columnPlusOne]) 
						{
							won = true;
						}
						else {
							won = false;
						}
					}
				}
			}
		}
		return won;
	}

	//METHOD 2:
	public boolean winVertically() 
	{	
		boolean won = false;
		
		for (int row = 0; row < grid.length && !won; row++) 
		{
			for (int column = 0; column < grid[row].length && !won; column++) 
			{
				//Get 4 elements below/on top of each other to test with on each row.
				int rowPlusOne = row + 1;
				int rowPlusTwo = row + 2;
				int rowPlusThree = row + 3;
				
				// make sure the elements are not past the size of the grid, since we cannot extend past the length of the grid.
				if (rowPlusOne < grid.length && rowPlusTwo < grid.length && rowPlusThree < grid.length) 
				{
					//make sure the elements are not empty
					if (grid[row][column] != ' ' && grid[rowPlusOne][column] != ' ' && grid[rowPlusTwo][column] != ' ' && grid[rowPlusThree][column] != ' ') 
					{
						//check if the elements above/below each other are the same
						if (grid[row][column] == grid[rowPlusThree][column] && grid[row][column] == grid[rowPlusTwo][column] && grid[row][column] == grid[rowPlusOne][column]) 
						{
							won = true;
						}
					}
				}
			}
		}
		return won;
	}

	//METHOD 3:
	public boolean winDiagonallyUpwards() 
	{
		boolean win = false;
		for (int j = 3; j < grid.length; j++)  //we start from row = 3 since that's when we can possibly win diagonally upwards.
		{
			//make sure the column is less than the row length-3
			for (int i = 0; i < (grid[j].length - 3); i++) 
			{
				// check if the diagonals are blank
				if (grid[j][i] != ' ' && grid[j - 1][i + 1] != ' ' && grid[j - 2][i + 2] != ' ' && grid[j - 3][i + 3] != ' ') 
				{
					// check if the diagonals are equal to each other.
					if (grid[j][i] == grid[j - 1][i + 1] && grid[j][i] == grid[j - 2][i + 2] && grid[j][i] == grid[j - 3][i + 3]) 
					{
						win = true;
					}
					else {
						win = false;
					}
				}
			}
		}
		return win;
	}
	
	//METHOD 4:
	public boolean winDiagonallyDownwards() 
	{
		boolean win = false;
		for (int row = 3; row < grid.length && !win; row++) //we start from row = 3 since that's when we can possibly win diagonally downwards.
		{	
			//check if the column is less than the length of the row
			for (int column = 3; column < grid[row].length && !win; column++) //we start from column = 3 since that's when we can possibly win diagonally downwards.
			{
				// check if the diagonal elements are not just blank spaces
				if (grid[row][column] != ' ' && grid[row - 1][column - 1] != ' ' && grid[row - 2][column - 2] != ' ' && grid[row - 3][column - 3] != ' ') 
				{
					//check to see if the diagonal elements are the same (i.e equivalent)
					if (grid[row][column] == grid[row - 1][column - 1] && grid[row][column] == grid[row - 2][column - 2] && grid[row][column] == grid[row - 3][column - 3]) 
					{
						win = true;
					}
					else {
						win = false;
					}
				}
			}
		}
		return win;
	}

	// USE 4 METHODS ABOVE TO CHECK IF THE USER WON.
	public boolean didLastPieceConnect4() 
	{
		//if any of these conditions are true, they won.
		if (winHorizontally() || winVertically() || winDiagonallyUpwards()||  winDiagonallyDownwards()) 
		{
			return true;
		} 
		else {
			return false;
		}
	}

}

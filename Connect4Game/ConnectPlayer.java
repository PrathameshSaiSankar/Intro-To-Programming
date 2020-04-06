package connect4Game;

public abstract class ConnectPlayer 
{	public int currentPlayer;
	public char pieceOfPlayer;
	
	public void setPlayerPiece()
	{
		if(currentPlayer == 2) //if currentPlayer == player2
		{
			pieceOfPlayer = Connect4Grid.PLAYER2;
		}
		else { //if currentPlayer == player1
			pieceOfPlayer = Connect4Grid.PLAYER1;
		}
	}
	
	public char getPlayerPiece()
	{
		return pieceOfPlayer;
	}
	
	public void setPlayer(int player) 
	{
		currentPlayer = player;
	}
	public int getPlayer()
	{
		return currentPlayer;
	}

	public abstract void makeMove(Connect4Grid grid, ConnectPlayer player); //used in humanPlayer && randomAIPlayer classes
	
}


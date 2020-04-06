package connect4Game;

public interface Connect4Grid
{
	// final variables used in the game that don't change :
	static final char PLAYER1 = 'X';
	static final char PLAYER2 = 'O';
	static final char [][] grid = new char [6][7]; // a 2D Array with 6 rows and 7 columns.
	 
	// methods used for the game :
	public void emptyGrid();
	public String toString();
	public boolean isValidColumn(int column);
	public boolean isColumnFull(int column);
	public void dropPiece(ConnectPlayer player, int column);
	public boolean didLastPieceConnect4();
	public boolean isGridFull();
}

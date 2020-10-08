package bridgelabz.TicTacToe;

public class TicTacToeGame 
{
	private char []board;
	
	/**
	 * creates the initial board for playing
	 */
	public void createBoard() {
		this.board =  new char[10];
		for(int index = 1; index < 10 ; index++ )
			board[index] = ' ';
	}
	/**
	 * constructor for TicTacToeGame
	 */
	public TicTacToeGame() {
		super();
	}
	public static void main( String[] args )
    {
        System.out.println( "Welcome to Tic Tac Toe game" );
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        ticTacToeGame.createBoard();
    }
}

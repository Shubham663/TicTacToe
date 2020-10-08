package bridgelabz.TicTacToe;

import java.util.Scanner;

public class TicTacToeGame {
	private char[] board;
	private char playerSign;
	private char computerSign;

	/**
	 * creates the initial board for playing
	 */
	public void createBoard() {
		this.board = new char[10];
		for (int index = 1; index < 10; index++)
			board[index] = ' ';
	}

	/**
	 * constructor for TicTacToeGame
	 */
	public TicTacToeGame() {
		super();
	}

	/**
	 * this method determines sign for user on tic tac toe board
	 */
	private void determinePlayerCharacter() {
		Scanner sc=new Scanner(System.in);
		int count = 0;
		while(true) {
			count++;
			System.out.println("Enter X or O for assigning character to Player");
			String s= sc.nextLine();
			playerSign = s.charAt(0);
			if(playerSign!= 'X' && playerSign!='O') {
				if(count == 5) {
					System.out.println("Invalid input to many times. Exiting");
					System.exit(0);
				}
				System.out.println("Please provide valid input");
				continue;
			}
			break;
		}
		if(playerSign == 'X')
			computerSign = 'O';
		else
			computerSign = 'X';
		System.out.println("The character chosen by player is " + playerSign);
	}
	
	/**
	 * Prints the values currently present in board
	 */
	private void displayBoard() {
		System.out.println("The values of the board are as follows");
		for(int boardPositionRow = 1; boardPositionRow <=3 ; boardPositionRow++) {
			for(int boardPositionColumn = 1; boardPositionColumn <=3 ; boardPositionColumn++){
			System.out.print(board[(boardPositionRow-1)*3 +boardPositionColumn] + " ");
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.createBoard();
		ticTacToeGame.determinePlayerCharacter();
		ticTacToeGame.displayBoard();
	}
}

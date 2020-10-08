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

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.createBoard();
		ticTacToeGame.determinePlayerCharacter();
	}

	/**
	 * this method determines sign for user on tic tac toe board
	 */
	private void determinePlayerCharacter() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter X or O for assigning character to Player");
			String s= sc.nextLine();
			playerSign = s.charAt(0);
			if(playerSign!= 'X' && playerSign!='O')
				continue;
			break;
		}
		if(playerSign == 'X')
			computerSign = 'O';
		else
			computerSign = 'X';
		System.out.println("The character chosen by player is " + playerSign);
	}
}

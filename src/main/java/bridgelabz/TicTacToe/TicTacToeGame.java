package bridgelabz.TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {
	private char[] board;
	private char playerSign;
	private char computerSign;
	private enum Players{
		Player,
		Computer
	}

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
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			count++;
			System.out.println("Enter X or O for assigning character to Player");
			String s = sc.nextLine();
			playerSign = s.charAt(0);
			if (playerSign != 'X' && playerSign != 'O') {
				if (count == 5) {
					System.out.println("Invalid input to many times. Exiting");
					System.exit(0);
				}
				System.out.println("Please provide valid input");
				continue;
			}
			break;
		}
		if (playerSign == 'X')
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
		System.out.print("-------------");
		for (int boardPositionRow = 1; boardPositionRow <= 3; boardPositionRow++) {
			System.out.print("\n|");
			for (int boardPositionColumn = 1; boardPositionColumn <= 3; boardPositionColumn++) {
				System.out.print(" " + board[(boardPositionRow - 1) * 3 + boardPositionColumn] + " |");
			}
			System.out.print("\n-------------");
		}
	}

	/**
	 * this method allows user to set his sign at particular position
	 */
	private int makeMove(Players player) {
		char sign;
		if(player == Players.Player)
			sign = playerSign;
		else
			sign = computerSign;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the positions b/w 1-9");
		int position = 0;
		try {
			position = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("The position provided is not correct");
			return 0;
		}
		if (position < 1 || position > 9) {
			System.out.println("Invalid position specified");
			return 0;
		}
		if (board[position] == ' ') {
			board[position] = sign;
			return position;
		} else {
			System.out.println("The position is already filled");
			return 0;
		}

	}
	
	/**
	 * @return, returns the player who plays first
	 */
	private Players whoPlaysFirst() {
		int k = (int)Math.floor(Math.random()*10)%2;
		if( k == 0 )
			return Players.Player;
		else
			return Players.Computer;
	}

	private void whoWins(Players player) {
		for(int turn =0; turn < 9; turn++) {
			if(turn%2 == 0) 
				this.makeMove(player);
			else {
				if(player == Players.Player)
					this.makeMove(Players.Computer);
				else
					this.makeMove(Players.Player);
			}
			if(board[1] == playerSign  && board[2] ==playerSign  && board[3]==playerSign ||
			   board[4] ==playerSign  && board[5] ==playerSign  && board[6]==playerSign ||
			   board[7] ==playerSign  && board[8] ==playerSign  && board[9]==playerSign ||
			   board[1] ==playerSign  && board[4] ==playerSign  && board[7]==playerSign ||
			   board[2] ==playerSign  && board[5] ==playerSign  && board[8]==playerSign ||
			   board[3] ==playerSign  && board[6] ==playerSign  && board[9]==playerSign ||
			   board[1] ==playerSign  && board[5] ==playerSign  && board[9]==playerSign ||
			   board[3] ==playerSign  && board[5] ==playerSign  && board[7]==playerSign ) {
					System.out.println("Player won");
					return;
			}
			else if (board[1] == computerSign  && board[2] ==computerSign  && board[3]==computerSign ||
					 board[4] ==computerSign  && board[5] ==computerSign  && board[6]==computerSign ||
					 board[7] ==computerSign  && board[8] ==computerSign  && board[9]==computerSign ||
					 board[1] ==computerSign  && board[4] ==computerSign  && board[7]==computerSign ||
					 board[2] ==computerSign  && board[5] ==computerSign  && board[8]==computerSign ||
					 board[3] ==computerSign  && board[6] ==computerSign  && board[9]==computerSign ||
					 board[1] ==computerSign  && board[5] ==computerSign  && board[9]==computerSign ||
					 board[3] ==computerSign  && board[5] ==computerSign  && board[7]==computerSign) {
					System.out.println("Computer won");
					return;
			}
			this.displayBoard();
		}
		System.out.println("The Game is tied");
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.createBoard();
		ticTacToeGame.determinePlayerCharacter();
		ticTacToeGame.displayBoard();
		Players player = ticTacToeGame.whoPlaysFirst();
		System.out.print("\n" + player +" gets to play first");
		ticTacToeGame.whoWins(player);
	}
}

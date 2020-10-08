package bridgelabz.TicTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	private char[] board;
	private char playerSign;
	private char computerSign;

	private enum Players {
		Player, Computer
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
		System.out.println("\nThe values of the board are as follows");
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
		if (player == Players.Player)
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
		return this.fillPosition(position, sign);
	}

	/**
	 * @param position, the position at which letter is to be placed
	 * @param sign,     the letter that is to be placed
	 * @return the position at which the character was placed
	 */
	public int fillPosition(int position, char sign) {
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
		int k = (int) Math.floor(Math.random() * 10) % 2;
		if (k == 0)
			return Players.Player;
		else
			return Players.Computer;
	}

	/**
	 * Determines who wins, player or computer
	 * 
	 * @param player, determines who takes the first turn
	 */
	private void whoWins(Players player) {
		for (int turn = 0; turn < 9; turn++) {
			if (turn % 2 == 0 && player == Players.Player || turn % 2 == 1 && player == Players.Computer)
				this.makeMove(Players.Player);
			else {
				this.computersMove();
			}
			this.displayBoard();
			if (board[1] == playerSign && board[2] == playerSign && board[3] == playerSign
					|| board[4] == playerSign && board[5] == playerSign && board[6] == playerSign
					|| board[7] == playerSign && board[8] == playerSign && board[9] == playerSign
					|| board[1] == playerSign && board[4] == playerSign && board[7] == playerSign
					|| board[2] == playerSign && board[5] == playerSign && board[8] == playerSign
					|| board[3] == playerSign && board[6] == playerSign && board[9] == playerSign
					|| board[1] == playerSign && board[5] == playerSign && board[9] == playerSign
					|| board[3] == playerSign && board[5] == playerSign && board[7] == playerSign) {
				System.out.println("\nPlayer won");
				return;
			} else if (board[1] == computerSign && board[2] == computerSign && board[3] == computerSign
					|| board[4] == computerSign && board[5] == computerSign && board[6] == computerSign
					|| board[7] == computerSign && board[8] == computerSign && board[9] == computerSign
					|| board[1] == computerSign && board[4] == computerSign && board[7] == computerSign
					|| board[2] == computerSign && board[5] == computerSign && board[8] == computerSign
					|| board[3] == computerSign && board[6] == computerSign && board[9] == computerSign
					|| board[1] == computerSign && board[5] == computerSign && board[9] == computerSign
					|| board[3] == computerSign && board[5] == computerSign && board[7] == computerSign) {
				System.out.println("\nComputer won");
				return;
			}
		}
		System.out.println("\nThe Game is tied");
	}

	/**
	 * Determines where the computer places its letter.
	 */
	private void computersMove() {
		if (this.blockPlayerWinningPosition())
			return;
		if (this.blockPosition(computerSign))
			return;

		while (true) {
			int position = new Random().nextInt(9) + 1;
			if (this.fillPosition(position, computerSign) != 0)
				break;
		}
	}

	/**
	 * @return returns true if winning position of opponent successfully blocked.
	 */
	private boolean blockPlayerWinningPosition() {
		if (this.blockPosition(playerSign))
			return true;
		return false;
	}

	/**
	 * @param sign, is computerSign or playerSign depending whether checking for
	 *              winning position or for blocking opponents winning
	 *              position. @return, returns true is particular position is
	 *              successfully blocked
	 */
	private boolean blockPosition(char sign) {
		switch (0) {
		case 0:
			if (board[1] == sign && board[2] == sign)
				if (board[3] == ' ') {
					board[3] = computerSign;
					return true;
				}
		case 1:
			if (board[3] == sign && board[2] == sign)
				if (board[1] == ' ') {
					board[1] = computerSign;
					return true;
				}
		case 2:
			if (board[1] == sign && board[3] == sign)
				if (board[2] == ' ') {
					board[2] = computerSign;
					return true;
				}
		case 3:
			if (board[4] == sign && board[5] == sign)
				if (board[6] == ' ') {
					board[6] = computerSign;
					return true;
				}
		case 4:
			if (board[5] == sign && board[6] == sign)
				if (board[4] == ' ') {
					board[4] = computerSign;
					return true;
				}
		case 5:
			if (board[4] == sign && board[6] == sign)
				if (board[5] == ' ') {
					board[5] = computerSign;
					return true;
				}
		case 6:
			if (board[7] == sign && board[8] == sign)
				if (board[9] == ' ') {
					board[9] = computerSign;
					return true;
				}
		case 7:
			if (board[8] == sign && board[9] == sign)
				if (board[7] == ' ') {
					board[7] = computerSign;
					return true;
				}
		case 8:
			if (board[7] == sign && board[9] == sign)
				if (board[8] == ' ') {
					board[8] = computerSign;
					return true;
				}
		case 9:
			if (board[1] == sign && board[4] == sign)
				if (board[7] == ' ') {
					board[7] = computerSign;
					return true;
				}
		case 10:
			if (board[4] == sign && board[7] == sign)
				if (board[1] == ' ') {
					board[1] = computerSign;
					return true;
				}
		case 11:
			if (board[1] == sign && board[7] == sign)
				if (board[4] == ' ') {
					board[4] = computerSign;
					return true;
				}
		case 12:
			if (board[5] == sign && board[8] == sign)
				if (board[2] == ' ') {
					board[2] = computerSign;
					return true;
				}
		case 13:
			if (board[2] == sign && board[5] == sign)
				if (board[8] == ' ') {
					board[8] = computerSign;
					return true;
				}
		case 14:
			if (board[2] == sign && board[8] == sign)
				if (board[5] == ' ') {
					board[5] = computerSign;
					return true;
				}
		case 15:
			if (board[9] == sign && board[6] == sign)
				if (board[3] == ' ') {
					board[3] = computerSign;
					return true;
				}
		case 16:
			if (board[3] == sign && board[6] == sign)
				if (board[9] == ' ') {
					board[9] = computerSign;
					return true;
				}
		case 17:
			if (board[3] == sign && board[9] == sign)
				if (board[6] == ' ') {
					board[6] = computerSign;
					return true;
				}
		case 18:
			if (board[1] == sign && board[5] == sign)
				if (board[9] == ' ') {
					board[9] = computerSign;
					return true;
				}
		case 19:
			if (board[5] == sign && board[9] == sign)
				if (board[1] == ' ') {
					board[1] = computerSign;
					return true;
				}
		case 20:
			if (board[1] == sign && board[9] == sign)
				if (board[5] == ' ') {
					board[5] = computerSign;
					return true;
				}
		case 21:
			if (board[5] == sign && board[3] == sign)
				if (board[7] == ' ') {
					board[7] = computerSign;
					return true;
				}
		case 22:
			if (board[5] == sign && board[7] == sign)
				if (board[3] == ' ') {
					board[3] = computerSign;
					return true;
				}
		case 23:
			if (board[3] == sign && board[7] == sign)
				if (board[5] == ' ') {
					board[5] = computerSign;
					return true;
				}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe game");
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.createBoard();
		ticTacToeGame.determinePlayerCharacter();
		ticTacToeGame.displayBoard();
		Players player = ticTacToeGame.whoPlaysFirst();
		System.out.print("\n" + player + " gets to play first");
		ticTacToeGame.whoWins(player);
	}
}

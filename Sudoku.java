import java.util.Random;

public class Sudoku {

	int [][] board;

	public Sudoku() {
		board = new int[9][9];
	}

	public void setNumber(int row, int col, int num) {
		this.board[row][col] = num;
	}

	public int getNumber(int row, int col) {
		return board[row][col];
	}

	public void cleanBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; i < 8; j++) {
				this.board[i][j] = 0;
			}
		}
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9) + 1;
	}

	public void printHorizontalLine() {
		System.out.println(" --------------------------- ");
	}

	public void printBoard() {
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) printHorizontalLine();
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) System.out.print(" | ");
				System.out.print(this.board[i][j] + " ");
			}
			System.out.println("| ");
		}
		printHorizontalLine();
	}

	public static void main(String args[]) {
		Sudoku sudoku = new Sudoku();
		sudoku.printBoard();
	}

}
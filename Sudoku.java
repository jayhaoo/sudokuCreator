import java.util.Random;

public class Sudoku {
	// testing
	//TODO: update setNumber to check if column, row and section works

	int [][] board;
	int row;
	int col;

	public Sudoku() {
		board = new int[9][9];
		row = 0;
		col = 0;
	}

	public void setNumber(int row, int col, int num) {
		if ((num > 0) && (num < 10)) {
			this.board[row][col] = num;
		} else {
			System.out.println("Error: Can't set board[" + row + "][" + col + "] to " + num);
		}
	}

	public int getNumber(int row, int col) {
		return board[row][col];
	}

	public boolean fillBoard(int row, int col) {
		int num = randomNumber();
		if (board[8][8] != 0) {
			return true;
		}
		/**
		for (int i = 0; i < 9; i++) {
			if ()
		}
		**/
		return false;
	}

	public boolean possibleMove(int row, int col, int num) {
		int sectionalRow = 0;
		int sectionalCol = 0;
		if (row > 2 && row < 6) {sectionalRow = 3;}
		else if (row > 5) {sectionalRow = 6;}
		if (col > 2 && col < 6) {sectionalCol = 3;}
		else if (col > 5) {sectionalCol = 3;}
		if ((num > 9) || (num < 1)) {
			System.out.println("Error: Number needs to be between 1 - 9");
			return false;
		}

		for (int i = 0; i < 9; i++) {
			if (board[row][i] == num) return false;
		}

		for (int j = 0; j < 9; j++) {
			if (board[j][col] == num) return false;
		}

		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (board[k+sectionalRow][l+sectionalCol] == num) return false;
			}
		}
		return true;
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
		if (args.length == 1) {
			System.out.println(args[0]);
		}
		
		Sudoku sudoku = new Sudoku();
		//sudoku.printBoard();
		sudoku.setNumber(0,0,3);
		sudoku.printBoard();
		System.out.println(sudoku.possibleMove(3,1,3));
		//sudoku.fillBoard(0,0);
		//sudoku.setNumber(0,0,3);
		//sudoku.printBoard();
	}

}

import java.util.Random;

public class Sudoku {
	int [][] board = new int [9][9];
	int row = 0; 
	int col = 0; 
	int num = randomNumber();

	public static void main (String[] args) {
		Sudoku sudoku = new Sudoku();
		sudoku.fillBoard();
		sudoku.printBoard(); 
	} 

	public void fillBoard() {
		for(int i = 0; i < 9; i++) 
			for(int j = 0; j < 9; j++) 
				board[i][j] = 0;
		fillBoard(0,0);
	}

	public boolean fillBoard(int row, int col) {
		num = randomNumber(); 
		if(board[8][8] != 0) return true;

		for(int i = 0; i < 9; i++) {
			if(possibleMove(row,col,num)) {
				board[row][col] = num;
				if(col == 8) {
					col = 0;
					row++;
					if(fillBoard(row,col)) return true;
				} else {
					col++;
					if(fillBoard(row,col)) return true;
				} 
			}
			num = num > 8 ? 1 : num + 1;
		} 
		board[row][col] = 0;
		return false; 
	} 	

	public boolean possibleMove(int row, int col, int num) {
		int sectionalRow = 0;
		int sectionalCol = 0;

		if ((num > 9) || (num < 1)) {
			System.out.println("Error: Number needs to be between 1 - 9");
			return false;
		}

		if (row > 2 && row < 6) {sectionalRow = 3;}
		else if (row > 5) {sectionalRow = 6;}

		if (col > 2 && col < 6) {sectionalCol = 3;}
		else if (col > 5) {sectionalCol = 6;}

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
				System.out.print(board[i][j] + " ");
			}
			System.out.println("| ");
		}
		printHorizontalLine();
	}

}

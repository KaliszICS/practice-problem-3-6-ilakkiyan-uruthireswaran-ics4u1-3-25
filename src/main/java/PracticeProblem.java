public class PracticeProblem {

	public static int searchMazeMoves(String[][] arr) {
		int row = arr.length - 1;
		int column = 0;
		int numOfMoves = 0;

		return SearchMazeMovesHelper(row, column, arr, numOfMoves);
	}

	private static int SearchMazeMovesHelper(int row, int column, String[][] arr, int moves) {
		if (row < 0 || row >= arr.length || column < 0 || column >= arr[row].length) {
			return -1;
		}
		if (arr[row][column].equals("F")) {
			return moves;
		}

		int right = SearchMazeMovesHelper(row, column + 1, arr, moves + 1);
		int up = SearchMazeMovesHelper(row - 1, column, arr, moves + 1);

		if (right != -1 && up != -1) {
			return Math.min(right, up);
		}

		else if (right == -1) {
			return up;
		}

		else if (arr[row][column].equals("*")) {
			return Math.min(right, up);
		}

		else {
			return right;
		}
	}

	public static int noOfPaths(String[][] arr) {
		int row = arr.length - 1;
		int column = 0;

		return noOfPathsHelper(arr, row, column);
	}

	private static int noOfPathsHelper(String[][] arr, int row, int column) {
		if (row < 0 || row >= arr.length || column < 0 || column >= arr[row].length) {
			return 0;
		}

		if (arr[row][column].equals("*")) {
			return 0;
		}

		if (arr[row][column].equals("F")){
			return 1;
		}

		String temp = arr[row][column];
		arr[row][column] = "*";

		int right = noOfPathsHelper(arr, row, column + 1);
		int up = noOfPathsHelper(arr, row - 1, column);

		arr[row][column] = temp;

		return right + up;
	}


	public static void main(String args[]) {
		String[][] walls = {
			{"", "", "", "", "F"},
			{"*", "", "", "*", ""},
			{"*", "*", "", "", "*"},
			{"", "*", "", "*", ""},
			{"S", "", "", "*", ""} 
		};
		int result = searchMazeMoves(walls);
		System.out.println(result);
		
		int result2 = noOfPaths(walls);
		System.out.println(result2);
	}

	
}

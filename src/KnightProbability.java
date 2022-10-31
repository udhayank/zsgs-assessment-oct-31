import java.util.Arrays;

public class KnightProbability {

	public static void main(String[] args) {
		
//		System.out.println(new KnightProbability().findProbability(1, 0, 0, 0));
		System.out.println(new KnightProbability().findProbability(3, 2, 0, 0));
//		System.out.println(new KnightProbability().findProbability(10, 3, 5, 5));
		
	}
	
	double prob = 0;
	
	public double findProbability(int n, int k, int r, int c) {
		
		if (k == 0 && r < n && n >= 0 && c < n && c >= 0) {
			return 1.0;
		}
		
		int[][] board = new int[n][n];
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				
				// fill each cell with number of positions inside the board the knight can jump to
				board[i][j] = fillSquare(i, j, n);
				
			}
		}
		
		for (int[] row:board) {
			System.out.println(Arrays.toString(row));
		}
		
		prob = 0;
		
		moveKnight(r+2, c+1, 1, board, k);
		moveKnight(r+2, c-1, 1, board, k);
		moveKnight(r-2, c+1, 1, board, k);
		moveKnight(r-2, c-1, 1, board, k);
		moveKnight(r+1, c+2, 1, board, k);
		moveKnight(r+1, c-2, 1, board, k);
		moveKnight(r-1, c+2, 1, board, k);
		moveKnight(r-1, c-2, 1, board, k);
		
		return prob;
		
	}

	private void moveKnight(int r, int c, int step, int[][] board, int k) {
		
		if (r < 0 || r >= board.length || c < 0 || c >= board.length) {
			return;
		}
		
		if (step == k-1) {
//			System.out.println((double) board[r][c]/(Math.pow(8, step+1)) + " " + r + " " + c);
			prob += (double) board[r][c]/(Math.pow(8, step+1));
			return;
		}
		
		moveKnight(r+2, c+1, step+1, board, k);
		moveKnight(r+2, c-1, step+1, board, k);
		moveKnight(r-2, c+1, step+1, board, k);
		moveKnight(r-2, c-1, step+1, board, k);
		moveKnight(r+1, c+2, step+1, board, k);
		moveKnight(r+1, c-2, step+1, board, k);
		moveKnight(r-1, c+2, step+1, board, k);
		moveKnight(r-1, c-2, step+1, board, k);
		
	}

	private int fillSquare(int i, int j, int n) {
		
		int count = 0;
		
		if (i+2 < n && j + 1 < n) {
			count++;
		}
		if (i+2 < n && j - 1 >= 0) {
			count++;
		}
		if (i-2 >= 0 && j + 1 < n) {
			count++;
		}
		if (i-2 >= 0 && j - 1 >= 0) {
			count++;
		}
		if (i+1 < n && j + 2 < n) {
			count++;
		}
		if (i+1 < n && j - 2 >= 0) {
			count++;
		}
		if (i-1 >= 0 && j + 2 < n) {
			count++;
		}
		if (i-1 >= 0 && j - 2 >= 0) {
			count++;
		}
		
		return count;
	}

}

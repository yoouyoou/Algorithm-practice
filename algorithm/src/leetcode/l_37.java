package leetcode;

public class l_37 {

	static boolean[][] vRow, vCol, vBox;	//visited배열
	
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
		
		solveSudoku(board);
		solve(board, 0, 0);
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++)
				System.out.print(board[i][j]+" ");
			System.out.println();
		}
	}
	
	public static void solveSudoku(char[][] board) {
		vRow = new boolean[9][10];	//i번째 열에서 쓰인 0~9 까지의 숫자 쓰임 여부
		vCol = new boolean[9][10];
		vBox = new boolean[9][10];
		
		init(board);
    }
	
	public static void init(char[][] board) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(board[i][j] != '.') {
					int val = board[i][j] - '0';
					vRow[i][val] = vCol[j][val] = true;
					vBox[getBoxNum(i,j)][val] = true;
				}
			}
		}
	}
	
	public static boolean solve(char[][] board, int r, int c) {
		if(r == 9)
			return true;
		
		int nc = (c == 8) ? 0 : c + 1;
		int nr = (nc == 0) ? r + 1 : r;
		
		if(board[r][c] != '.')
			return solve(board, nr, nc);
		
		for(int i = 1; i < 10; i++) {
			int box = getBoxNum(r, c);
			
			if(vRow[r][i] || vCol[c][i] || vBox[box][i])
				continue;
			
			board[r][c] = (char) (i + '0');
			vRow[r][i] = vCol[c][i] = vBox[box][i] = true;
			
			if(solve(board, nr, nc))
				return true;
			
			vRow[r][i] = vCol[c][i] = vBox[box][i] = false;
			board[r][c] = '.';
		}
		
		return false;
	}
	
	public static int getBoxNum(int i, int j) {
		return (i / 3 * 3) + (j / 3);
	}

}

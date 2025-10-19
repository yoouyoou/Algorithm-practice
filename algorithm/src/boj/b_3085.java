package boj;

import java.util.Scanner;

public class b_3085 {

	static int N, answer;
	static char[][] board;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new char[N][N];
		
		for(int i = 0; i < N; i++)
			board[i] = sc.next().toCharArray();
		
		sc.close();
		
		for(int i = 0; i < N; i++) {
			rowCount(i);
			colCount(i);
			if(answer == N) {
				System.out.println(answer);
				return;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//오른쪽 swap
				if(j+1 < N && board[i][j] != board[i][j+1]) {
					swap(i, j, i, j+1);
					rowCount(i);
					colCount(j);
					colCount(j+1);
					swap(i, j, i, j+1);
				}
				
				//아래swap
				if(i+1 < N && board[i][j] != board[i+1][j]) {
					swap(i, j, i+1, j);
					colCount(j);
					rowCount(i);
					rowCount(i+1);
					swap(i, j, i+1, j);
				}
			}
			if(answer == N)
				break;
		}
		
		System.out.println(answer);
	}
	
	public static void swap(int x1, int y1, int x2, int y2) {
		char temp = board[x1][y1];
		board[x1][y1] = board[x2][y2];
		board[x2][y2] = temp;
	}
	
	//행 카운트
	public static void rowCount(int row) {
		int count = 1, max = 0;
		
		for(int c = 0; c < N-1; c++) {
			if(board[row][c] == board[row][c+1])
				count++;
			else {
				max = Math.max(max, count);
				count = 1;
			}
		}
		max = Math.max(max, count);
		answer = Math.max(max, answer);
	}
	
	//열 카운트
	public static void colCount(int col) {
		int count = 1, max = 0;
		
		for(int r = 0; r < N-1; r++) {
			if(board[r][col] == board[r+1][col])
				count++;
			else {
				max = Math.max(max, count);
				count = 1;
			}
		}
		max = Math.max(max, count);
		answer = Math.max(max, answer);
	}

}
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l_54 {

	public static void main(String[] args) {
		int[][] m = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12}
		};
		
		for(int s: spiralOrder(m)) {
			System.out.print(s + " ");
		}
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		
		int r = 0, c = 0, idx = 0, cnt = 0;
		while(cnt < m * n) {

			if(idx == 0) {
				while(c < n && !visited[r][c]) {
					list.add(matrix[r][c]);
					visited[r][c] = true;
					c++; cnt++;
				}
				r++; c--;
				idx = 1;
			}
			
			if(idx == 1) {
				while(r < m && !visited[r][c]) {
					list.add(matrix[r][c]);
					visited[r][c] = true;
					r++; cnt++;
				}
				c--; r--;
				idx = 2;
			}
			
			if(idx == 2) {
				while(c >= 0 && !visited[r][c]) {
					list.add(matrix[r][c]);
					visited[r][c] = true;
					c--; cnt++;
				}
				r--; c++;
				idx = 3;
			}
			
			if(idx == 3) {
				while(r >= 0 && !visited[r][c]) {
					list.add(matrix[r][c]);
					visited[r][c] = true;
					r--; cnt++;
				}
				c++; r++;
				idx = 0;
			}
		}
		
		return list;
	}

}

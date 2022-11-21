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
//			System.out.print(s + " ");
		}
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		
		int r = 0, c = 0, idx = 0, cnt = 0;
		
		while(true) {
			
			if(cnt >= m * n)
				return list;
			
			if(idx == 0) {	// →
				System.out.println("인덱스0 진입");
				while(c < n) {
					if(!visited[r][c]) {
						visited[r][c] = true;
						list.add(matrix[r][c]);
						cnt++;
					}
					c++;
				}
				idx = 1;
				c--;
			}
			
			if(idx == 1) { // ↓
				System.out.println("인덱스1 진입");
				while(r < m) {
					if(!visited[r][c]) {
						visited[r][c] = true;
						list.add(matrix[r][c]);
						cnt++;
					}
					r++;
				}
				idx = 2;
				r--;
			}
			
			if(idx == 2) {	// ←
				while(c >= 0) {
					if(!visited[r][c]) {
						visited[r][c] = true;
						list.add(matrix[r][c]);
						cnt++;
					}
					c--;
				}
				idx++;
				c++;
				System.out.println("c요: " + c);
			}
			
			if(idx == 3) {		// ↑
				while(r >= 0) {
					if(!visited[r][c]) {
						visited[r][c] = true;
						list.add(matrix[r][c]);
						cnt++;
						r--;
					}
					else
						break;
//					r--;
				}
				idx = 0;
//				r++;
			}
			
			for(int t: list)
				System.out.print(t + " ");
			System.out.println();
			
		}
		
//		return list;
		
	}

}

package 이코테;

import java.util.Arrays;
import java.util.Scanner;

public class dp {
	
	public static void main(String[] args) {
		//testcase1 -> 19
		int n = 3;
		int m = 4;
		int[][] map = {{1, 3, 3, 2},
				{2, 1, 4, 1},
				{0, 6, 4, 7}};
		
		//testcase2 -> 16
//		int n = 4;
//		int m = 4;
//		int[][] map = {{1, 3, 1, 5},
//				{2, 2, 4, 1},
//				{5, 0, 2, 3},
//				{0, 6, 1, 2}};
		
		int[][] dp = new int[n][m];
		for(int i = 0; i < n; i++)
			dp[i][0] = map[i][0];
		
		for(int i = 1; i < m; i++) {		//열 검사
			for(int j = 0; j < n; j++) {	//행 검사
				int leftUp=0, leftDown=0, left=0;
				
				//[j-1][i-1] //[j][i-1]  //[j+1][i-1]
				if(j-1 >= 0 && j-1 < n)
					leftUp = dp[j-1][i-1];
				
				if(j >= 0 && j < n)
					left = dp[j][i-1];
				
				if(j+1 >= 0 && j+1 < n)
					leftDown = dp[j+1][i-1];
				
				dp[j][i] = Math.max(leftUp, Math.max(leftDown, left)) + map[j][i];
			}
		}
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(ans < dp[i][m-1])
				ans = dp[i][m-1];
		}
		
		System.out.println(ans);
	}

}

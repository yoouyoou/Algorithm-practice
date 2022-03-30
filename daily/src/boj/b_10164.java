package boj;

import java.util.Scanner;

//격자상의 경로(실버1)
public class b_10164 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] dp = new int[N+1][M+1];
		int answer = 0;
		boolean isVisited = false;
		
		//경유지 없는 경우
		if(K == 0) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(i == 1)
						dp[i][j] = 1;
					else if(j == 1)
						dp[i][j] = 1;
					else
						dp[i][j] += dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		//경유지 있는 경우
		else {
			int r, c;
//			int r = (K-1) / M + 1;
//			int c = (K-1) % M + 1;
			
			if(K % M == 0) {
				r = K / M;
				c = M;
			}else {
				r = K / M + 1;
				c = K % M;	
			}
			
			for(int i = 1; i <= N; i++) {
				if(isVisited)
					break;
				for(int j = 1; j <= M; j++) {
					if(i == 1)
						dp[i][j] = 1;
					else if(j == 1)
						dp[i][j] = 1;
					else
						dp[i][j] += dp[i-1][j] + dp[i][j-1];
					
					if(i == r && j == c) {
						answer = dp[r][c];
						dp[r][c] = 1;
						isVisited = true;
						break;
					}	
				}
				
			}
			
			for(int i = r; i <= N; i++) {
				for(int j = c; j <= M; j++) {
					if(i == r)
						dp[i][j] = 1;
					else if(j == c)
						dp[i][j] = 1;
					else
						dp[i][j] += dp[i-1][j] + dp[i][j-1];
				}
			}
			
			dp[N][M] *= answer;
		}
		
		System.out.println(dp[N][M]);
		sc.close();
	}

}

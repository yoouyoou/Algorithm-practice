package boj;

import java.util.Scanner;

//격자상의 경로(실버1)
public class b_10164 {

	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		dp = new int[N+1][M+1];
		dp[1][1] = 1;
		
		if(K == 0) {	//꼭 거쳐가지 않아도 되는 경우
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(i == 1 && j == 0)
						continue;
					dp[i][j] = i < 0 ? 0 : dp[i][j] + j < 0 ? 0 : dp[i][j];
				}
			}
		}
		else {
			int r = K / M + 1;
			int c = K % M;
			
			for(int i = 1; i <= r; i++) {
				for(int j = 1; j <= c; j++) {
					if(i == 1 && j == 1)
						continue;
					dp[i][j] = i < 0? 0:dp[i][j] + j<0?0:dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N][M]);
		sc.close();
	}

}

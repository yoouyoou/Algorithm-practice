package b_normal_bag;

import java.util.Scanner;

//골드5
public class b_12865 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] w = new int[N+1];				// 무게 배열
		int[] v = new int[N+1];				// 가중치 배열
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i <= N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= K; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0)
					dp[i][j] = Math.max( dp[i-1][j], dp[i-1][j-w[i]] + v[i] );
			}
		}
		
		for(int i =1; i <= N; i++) {
			for(int j = 1; j <= K; j++)
				System.out.print(dp[i][j] + " | ");
			System.out.println();
		}
		
		System.out.println(dp[N][K]);
		sc.close();
		
	}

}

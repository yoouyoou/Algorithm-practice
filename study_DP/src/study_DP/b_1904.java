package study_DP;

import java.util.Scanner;

//01≈∏¿œ
public class b_1904 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1) {
			System.out.println("1");
			return;
		}
		
		if(N == 2) {
			System.out.println("2");
			return;
		}
		
		int[] dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 15746;
		}
		
		System.out.println(dp[N]);
	}

}

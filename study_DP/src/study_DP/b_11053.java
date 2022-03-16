package study_DP;

import java.util.Scanner;

public class b_11053 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] A = new int[N];
		int[] dp = new int[N];
		
		for(int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		dp[0] = 1;
		for(int i = 1; i < N; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++)
				if(A[i] > A[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			System.out.print(dp[i] + " ");
			if(dp[i] > ans)
				ans = dp[i];
		}
		
		sc.close();
	}

}

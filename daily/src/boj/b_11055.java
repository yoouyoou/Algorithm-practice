package boj;

import java.util.Scanner;

public class b_11055 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int A[] = new int[N+1];
		int dp[] = new int[N+1];
		
		for(int i = 1; i <= N; i++)
			A[i] = sc.nextInt();
		
		dp[1] = A[1];
		for(int i = 2; i <= N; i++) {
			dp[i] = A[i];
			for(int j = 1; j < i; j++)
				if(A[i] > A[j])
					dp[i] = Math.max(dp[i], dp[j] + A[i]);
		}
		
		int ans = 0;
		for(int i = 1; i <= N; i++) {
			if(dp[i] > ans)
				ans = dp[i];
		}
		
		System.out.println(ans);
		sc.close();
	}

}

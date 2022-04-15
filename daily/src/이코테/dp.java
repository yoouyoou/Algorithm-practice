package 이코테;

import java.util.Arrays;
import java.util.Scanner;

public class dp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//화폐 단위
		int M = sc.nextInt();	//최소 가치
		int[] money = new int[N];
		int[] dp = new int[M+1];
		
		
		for(int i = 0; i < N; i++)
			money[i] = sc.nextInt();
		
		Arrays.fill(dp, 10001);
		dp[0] = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= M - money[i]; j++)
				if(dp[j] != 10001)
					dp[j + money[i]] = Math.min(dp[j+money[i]], dp[j] + 1);
				
		}
		
		if(dp[M] == 10001)
			System.out.println("-1");
		else
			System.out.println(dp[M]);
	}

}

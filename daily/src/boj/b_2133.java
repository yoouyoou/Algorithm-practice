package boj;

import java.util.Scanner;

//타일 채우기(골드5)
public class b_2133 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int answer = 0;
		if(n % 2 == 1)
			answer = 0;
		else {
			dp[0] = 1;
			dp[2] = 3;
			for(int i = 4; i <= n; i += 2) {
				dp[i] = dp[i-2] * dp[2];
				for(int j = i-4; j >= 0; j -=2)
					dp[i] += dp[j] * 2;
			}
			answer = dp[n];
		}
		
		System.out.println(answer);
		sc.close();
	}

}

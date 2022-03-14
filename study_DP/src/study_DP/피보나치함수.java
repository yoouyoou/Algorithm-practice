package study_DP;

import java.util.Scanner;

public class 피보나치함수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	//테스트 케이스 개수
		
		int max = 0;
		int[] tarr = new int[T];
		for(int i = 0; i < T; i++) {
			tarr[i] = sc.nextInt();	//테스트 예제 담기
			if(tarr[i] > max)
				max = tarr[i];
		}
		
		int[][] dp = new int[max+1][2];		//0횟수, 1횟수를 담기 위해 2차원 배열
		
		//F[0] = 0
		dp[0][0] = 1;
		dp[0][1] = 0;
		
		//F[1] = 1
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i = 2; i <= max; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1]; 
		}
		
		for(int i = 0; i < tarr.length; i++) {
			System.out.println(dp[tarr[i]][0] + " " + dp[tarr[i]][1]);
		}

		sc.close();
	}

}

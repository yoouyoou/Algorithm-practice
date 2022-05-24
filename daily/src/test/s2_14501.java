package test;

import java.util.Scanner;

//Επ»η
public class s2_14501 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[2][N + 1];
		int[] dp = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[0][i] = sc.nextInt();
			arr[1][i] = sc.nextInt();
		}
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			if(i + arr[0][i] + i <= N) {
				dp[i] = Math.max(dp[i], max);
				dp[arr[0][i] + i] = Math.max(dp[arr[0][i] + i], arr[1][i] + dp[i]);
				max = Math.max(max, dp[i]);	
			}
		}
		
		System.out.println(max);
	}

}

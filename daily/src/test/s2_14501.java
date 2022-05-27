package test;

import java.util.Scanner;

//퇴사
public class s2_14501 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[N+1];		//걸린 날짜
		int[] P = new int[N+1];		//얻는 이익
		int[] dp = new int[N+2];	//N일 까지는 일이 가능해서 N+1일날 돈을 받을 수 있음
		
		for(int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		sc.close();
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			
			if(i + T[i] <= N+1) 
				dp[T[i] + i] = Math.max(dp[T[i] + i], dp[i] + P[i]);	//Max(기존값, 현재최대수익+i번째 일 수행)
			
			max = Math.max(max, dp[i]);
		}
		
//		for(int a: dp)
//			System.out.print(a + " ");
//		System.out.println();
		
//		if(dp[N+1] == 0)
//			dp[N+1] = dp[N];
		
		max = Math.max(max, dp[N+1]);
		System.out.println(max);
	}

}

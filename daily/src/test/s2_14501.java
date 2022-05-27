package test;

import java.util.Scanner;

//���
public class s2_14501 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] T = new int[N+1];		//�ɸ� ��¥
		int[] P = new int[N+1];		//��� ����
		int[] dp = new int[N+2];	//N�� ������ ���� �����ؼ� N+1�ϳ� ���� ���� �� ����
		
		for(int i = 1; i <= N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		sc.close();
		
		int max = 0;
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			
			if(i + T[i] <= N+1) 
				dp[T[i] + i] = Math.max(dp[T[i] + i], dp[i] + P[i]);	//Max(������, �����ִ����+i��° �� ����)
			
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

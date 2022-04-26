package test;

import java.util.Scanner;

public class s1_23061 {

	static int answer, N, M;
	static int[] w, v;
	static int[][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();	//��ǰ�� ����
		M = sc.nextInt();	//���� ����
		w = new int[N+1];
		v = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			int w1 = sc.nextInt();	//�� ������ ����
			int v1 = sc.nextInt();	//��ġ
			w[i] = w1;
			v[i] = v1;
		}
		
		int[] bags = new int[M];
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < M; i++) {
			bags[i] = sc.nextInt();
			max = Math.max(max, bags[i]);
		}

		solution(max);	
		
		double effect = 0.0;
		for(int i = 0; i < M; i++) {
			if(effect < (double)dp[N][bags[i]] / (double)bags[i]) {
				effect = (double)dp[N][bags[i]] / (double)bags[i];
				answer = i+1;
			}
		}

		System.out.println(answer);
		sc.close();
	}

	public static void solution(int k) {
		dp = new int[N+1][1000001];	//[���� ��ȣ][���� �賶 ����]
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= k; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0)
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
			}
		}
		
	}
}

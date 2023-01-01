package study;

import java.util.Scanner;

public class b_1519 {
	
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		//�������� ����
		dp = new int[N + 1];		//0:��, 1:�̱�, -1:��
		
		if(N < 10)
			System.out.println(-1);
		else {
			for(int i = 0; i < 10; i++)
				dp[i] = -1;
			System.out.println( solution(N) );
		}
		
		sc.close();
	}
	
	public static int solution(int n) {
		//���а� ������ ��� �ٷ� ����
		if(dp[n] != 0)
			return dp[n];
		
		//�� �κ� ���ڿ� ���ϱ�
		int num = Integer.MAX_VALUE;
		boolean win = false;
		String str = String.valueOf(n);
		
		for(int i = 1; i < str.length(); i++) {
			for(int j = 0; j <= str.length() - i; j++) {
				int temp = Integer.parseInt(str.substring(j, j + i));	//���κ� ���ڿ�
				
				if(temp == 0)
					continue;
				
				if(solution(n-temp) == -1) {
					win = true;
					num = Math.min(num, temp);
				}
			}
		}
		
		//-1:�й� 0:��, �¸�:1
		if(win == false)
			return dp[n] = -1;
		
		return dp[n] = num;
	}
	

}

/*
 
 dp[i] : ����i(���ڿ�)�� ���ؼ� 0�� �й�, �� �ܴ� �¸�
 ���� ���, i�� ���� �ڸ� ���϶��� ������ ���Ƿ� dp[1] ~ dp[9] �� ������ 0��.
 �׸��� i=10�϶�,���κй��ڿ��� 1, 0 �ε� 0�� �ǹ̾����Ƿ� ���� 1�ϳ��� �θ� 1���� �� 9�ε� 
 dp[9]=0�̴ϱ� dp[10]=1 �̱� �� ����!
 
 */
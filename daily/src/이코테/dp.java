package ������;

public class dp {

	public static void main(String[] args) {
		int N = 26;
		int[] dp = new int[N+1];	//i�� 1�� ����� ���� �ּ� ����Ƚ��
		
		dp[1] = 0; // 1�� ��� ������ ������ �ʿ䰡 ���� ������
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;	//���� ������ 1�� ���� ���� ����Ƚ��
			
			if(i % 2 == 0)
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			
			if(i % 3 == 0)
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			
			if(i % 5 == 0)
				dp[i] = Math.min(dp[i], dp[i/5] + 1);
		}
		
		System.out.println(dp[N]);
	}

}

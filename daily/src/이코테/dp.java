package 이코테;

public class dp {

	public static void main(String[] args) {
		int N = 26;
		int[] dp = new int[N+1];	//i를 1로 만들기 위한 최소 연산횟수
		
		dp[1] = 0; // 1인 경우 연산을 수행할 필요가 없기 때문에
		
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + 1;	//현재 수에서 1을 빼서 나온 연산횟수
			
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

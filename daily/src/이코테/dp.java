package 이코테;

public class dp {

	public static void main(String[] args) {
		int N = 4; //식량 창고 개수
		int[] food = {1, 3, 1, 5};
		int[] dp = new int[N];
		
		dp[0] = food[0];
		dp[1] = food[1];
		for(int i = 2; i < N; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + food[i]);
		}
		
		System.out.println(dp[N-1]);

	}

}

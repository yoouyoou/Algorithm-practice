package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// RGB�Ÿ�
public class b_1149 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] cost = new int[N][3];
		int[][] dp = new int[N][3];
		
		//cost�Է� �ޱ�
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < 3; j++)
				cost[i][j] = Integer.parseInt(str[j]);
		}
		
		//dp����
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 0)
					dp[i][j] = cost[i][j];
				else {
					if(j == 0)	//rĥ�ϴ� ���
						dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][j];
					else if(j == 1)	//gĥ�ϴ� ���
						dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][j];
					else if(j == 2)	//bĥ�ϴ� ���
						dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][j];
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			if(dp[N-1][i] < min)
				min = dp[N-1][i];
		}
		
		System.out.println(min);
	}
	
}

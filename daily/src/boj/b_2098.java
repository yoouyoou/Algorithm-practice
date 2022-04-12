package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//���ǿ� ��ȸ
public class b_2098 {

	static int[][] w;
	static int[][] dp;
	static int N;
	static final int INF = 11000000;	//MAX: 11,000,000
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		dp = new int[N][(1 << N) - 1];	//[���� ��ġ ����][���ݱ��� �湮�� ���� 2����]
		
				
		//input
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				w[i][j] = Integer.parseInt(str[j]);
		}
		
		//dp�ʱ�ȭ
		for(int i = 0; i < N; i++)
			Arrays.fill(dp[i], INF);
		
		//solution
		int ans = dfs(0, 1);	//0�� ���ú��� �湮����: ��� ���ÿ��� �����ϵ� �ּҺ���� ����
		System.out.println(ans);
	}
	
	private static int dfs(int x, int visited) {
		if(visited == (1 << N)-1) {
			if(w[x][0] == 0)	//Ȥ�ó�
				return INF;
			
			return w[x][0];
		}
		
		if(dp[x][visited] != INF)
			return dp[x][visited];
		
		//���� ���ÿ��� �� i�� ���÷� DFS����
		for(int i = 0; i < N; i++) {
			if((visited & (1 << i)) == 0 && w[x][i] != 0) {
				dp[x][visited] = Math.min(dp[x][visited], dfs(i, visited | (1 << i)) + w[x][i]);
			}
		}
		
		return dp[x][visited];
	}

}

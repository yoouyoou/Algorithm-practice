package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ��������Ǵ� {

	static int n;
	static int[][] map;
	static int[][] dp;
	static int[] dr = {-1, 1, 0, 0};	//�����¿�
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
	
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int cur = dfs(i, j);
				ans = cur > ans ? cur : ans;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int dfs(int r, int c) {
		
		if(dp[r][c] != 0)
			return dp[r][c];
		
		dp[r][c] = 1;
		
		for(int i = 0; i < 4; i++) {	//�����¿� �湮
			int nextR = r + dr[i];		//�������� ������ ��ǥ
			int nextC = c + dc[i];	
			
			//���� ���� ���̰�, ���� ĭ�� ���� �� Ŀ�� �̵��� �� �ִ� ���
			if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
				if(map[nextR][nextC] > map[r][c])
					dp[r][c] = Math.max(dp[r][c], dfs(nextR, nextC) + 1);
			}
		}
		
		return dp[r][c];
	}

}

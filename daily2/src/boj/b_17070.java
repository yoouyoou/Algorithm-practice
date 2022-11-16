package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//������ �ű��1
public class b_17070 {

	static int[][] map;
	static int ans = 0;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
		
		dfs(0, 1, 0);
		
		System.out.println(ans);
		br.close();
	}
	
	//direct: 0-����, 1-����, 2-�밢��
	public static void dfs(int r, int c, int direction) {
		
		if(r >= N || c >= N || map[r][c] == 1) 
			return;
		
		if(r == N-1 && c == N-1) {
			ans++;
			return;
		}
		
		switch(direction) {
		case 0:
			//���� ����
			dfs(r, c+1, 0);
			if(c < N-1 && r < N-1) {
				if(map[r+1][c] == 0 && map[r][c+1] == 0 && map[r+1][c+1] == 0)
					dfs(r+1, c+1, 2);
			}
			break;
			
		case 1:
			//���� ����
			dfs(r+1, c, 1);
			
			if(c < N-1 && r < N-1) {
				if(map[r+1][c] == 0 && map[r][c+1] == 0 && map[r+1][c+1] == 0)
					dfs(r+1, c+1, 2);
			}
			break;
			
		case 2:
			//�밢�� ����
			dfs(r, c+1, 0);
			dfs(r+1, c, 1);
			
			if(c < N-1 && r < N-1) {
				if(map[r+1][c] == 0 && map[r][c+1] == 0 && map[r+1][c+1] == 0)
					dfs(r+1, c+1, 2);
			}
			break;
		}
		
	}

}

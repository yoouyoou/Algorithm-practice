package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 욕심쟁이판다 {

	static int n, ans = 0, max = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < n; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
	
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				ans = 0;
				visited[i][j] = true;
				dfs(i, j);
				visited[i][j] = false;
				System.out.println("dfs(" + i + ", " + j + ") = " + ans);
			}
		}
		
		System.out.println(max);
		br.close();
	}
	
	public static void dfs(int r, int c) {
		
//		visited[r][c] = true;			//방문표시
		ans++;							//길이 증가
		
//		System.out.println("dfs함수(" + r + ", " + c+"): " + ans);
		if(ans > max)
			max = ans;
		
		for(int i = 0; i < 4; i++) {	//상하좌우 방문
			int nextR = r + dr[i];		//다음으로 움직일 좌표
			int nextC = c + dc[i];	
			
			if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n) {
				if(map[nextR][nextC] > map[r][c] && !visited[nextR][nextC]) {
					visited[nextR][nextC] = true;
					dfs(nextR, nextC);
					visited[nextR][nextC] = false;
					ans--;
				}
			}
		}
		
		return;
	}

}

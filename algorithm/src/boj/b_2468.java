package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2468 {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int maxHeight = 0;
		int answer = 1;		// 비가 안오면 적어도 하나
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String strs = br.readLine();
			String[] str = strs.split(" ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				maxHeight = Math.max(map[i][j], maxHeight);
			}
		}
		
		for(int h = 1; h < maxHeight; h++) {
			int count = 0;
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] > h) {
						DFS(i, j, h);
						count++;
					}
				}
			}
			answer = Math.max(answer, count);
		}
		
		System.out.println(answer);
		
	}

	public static void DFS(int x, int y, int h) {
		if(visited[x][y])
			return;
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && map[nx][ny] > h)
				DFS(nx, ny, h);
		}
	}
}

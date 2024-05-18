package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1520 {

	static int dr[] = {-1, 1, 0 ,0};
	static int dc[] = {0, 0, -1, 1};
	static int total = 0, M, N;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		
		arr = new int[M][N];
		visited = new boolean[M][N];

		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}
		
		visited[0][0] = true;
		DFS(0, 0);
		System.out.println(total);
	}
	
	public static void DFS(int r, int c) {
		if(r == M-1 && c == N-1) {
			total++;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && arr[r][c] > arr[nr][nc]) {
				visited[nr][nc] = true;
				DFS(nr, nc);
				visited[nr][nc] = false;
			}
		}
	}

}

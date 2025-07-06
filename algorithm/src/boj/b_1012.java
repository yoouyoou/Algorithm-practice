package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1012 {

	static int[] dn = {0, 0, -1, 1};
	static int[] dm = {1, -1, 0, 0};
	
	static int[][] cabbage;
	static boolean[][] visited;
	static int M, N, total;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String[] str = br.readLine().split(" ");
			M = Integer.parseInt(str[0]);
			N = Integer.parseInt(str[1]);
			cabbage = new int[N][M];
			visited = new boolean[N][M];
			int K = Integer.parseInt(str[2]);
			
			for(int i = 0; i < K; i++) {
				String[] s = br.readLine().split(" ");
				cabbage[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
			}
			
			total = 0;
			solution(cabbage);
		}
	}
	
	public static void solution(int[][] cabbage) {
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(cabbage[n][m] == 1 && !visited[n][m]) {
					DFS(n, m);
					total++;
				}
			}
		}
		
		System.out.println(total);
	}
	
	public static void DFS(int n, int m) {
		// 양배추가 없거나 방문한 적이 있으면
//		if(cabbage[n][m] == 0 || visited[n][m])
//			return;
		visited[n][m] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = n + dn[i];
			int ny = m + dm[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(cabbage[nx][ny] == 1 && !visited[nx][ny])
					DFS(nx, ny);
			}
		}
	}
	
	public static void print(int[][] temp) {
		int x = temp.length;
		int y = temp[0].length; 
		
		System.out.println("-------------출력-------------------");
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");
	}
	
	public static void print2(boolean[][] temp) {
		int x = temp.length;
		int y = temp[0].length; 
		
		System.out.println("-------------출력-------------------");
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(temp[i][j])
					System.out.print("T ");
				else
					System.out.print("F ");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");
	}

}

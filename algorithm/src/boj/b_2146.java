package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//�ٸ� �����
public class b_2146 {

	private static int[] dr = {-1, 1, 0, 0};	//�����¿�
	private static int[] dc = {0, 0, -1, 1};
	private static int N, answer = Integer.MAX_VALUE;
	private static int[][] map;
	private static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		//input
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}	
		
		//dfs�� �� �и�
		int island = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j])	//�ϴ� ���̰�
					dfs(i, j, island++);
			}
		}
		
		//bfs����
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] > 0)
					bfs(i, j);
			}
		}
		
		System.out.println(answer-1);
		
	}
	
	public static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<Point>();
		
		q.offer(new Point(r, c, 0));
		int number = map[r][c];
		visited = new boolean[N][N];
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(answer <= now.count) 
				return;
			
			if(map[now.r][now.c] != 0 && map[now.r][now.c] != number) {
				answer = Math.min(answer, now.count);
//				System.out.println("����: " + answer);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >=0 && nc < N) {
					if(!visited[nr][nc] && map[nr][nc] != number) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, now.count+1));
					}
				}
			}
		}
	}
	
	public static void dfs(int r, int c, int num) {
		
		map[r][c] = num;
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(map[nr][nc] == 1 && !visited[nr][nc])
					dfs(nr, nc, num);
			}
		}
		
		return;
	}

}

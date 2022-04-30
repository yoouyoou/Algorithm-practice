package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//토마토
public class b_7576 {

	static Queue<Point> q;
	static int[][] visited;
	static int[] dr = {-1, 1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int answer = -1;
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		int[][] map = new int[N][M];
		visited = new int[N][M];
		q = new LinkedList<Point>();
		
		//input
		for(int i = 0; i <N; i++){
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(map[i][j] == 1)
					q.offer(new Point(i, j));
					
		//익은 토마토 모두 큐에 넣음
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] == 0 && visited[nr][nc] == 0) {
						visited[nr][nc] = visited[cur.r][cur.c] + 1;
						q.add(new Point(nr, nc));
					}	
				}
			}
			
		}
		
		f1:
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(visited[i][j] == 0 && map[i][j] == 0) {
					answer = -1;
					break f1;
				}
				answer = Math.max(answer, visited[i][j]);
			}
		}
		
		System.out.println(answer);
	}

}

class Point{
	int r, c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

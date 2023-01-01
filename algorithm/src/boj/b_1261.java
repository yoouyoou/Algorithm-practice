package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//알고스팟
public class b_1261 {

	static int[] dr = {-1, 1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	static int[][] map;
	static int[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N+1][M+1];
		visited = new int[N+1][M+1];
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <+ M; j++)
				visited[i][j] = Integer.MAX_VALUE;
		
		System.out.println(bfs());
	}

	public static int bfs() {
		Queue<Node1261> q = new LinkedList<Node1261>();
		q.offer(new Node1261(0, 0, 0));
		
		while(!q.isEmpty()) {
			Node1261 now = q.poll();
			
			if(now.r == N && now.c == M)
				return visited[now.r][now.c];
			
			for(int i = 0; i < 4; i++) {
				int nc = now.r + dr[i];
				int nr = now.c + dc[i];
				
				if(nr >= 1 && nr <= N && nc >= 1 && nc <= M) {	//격자 내이고
//					if(visited[nr][nc] == Integer.MAX_VALUE) {	//아직 방문안했을 경우
						if(map[nr][nc] == 1)	//벽일 경우
							visited[nr][nc] = Math.min(visited[nr][nc], visited[now.r][now.c]+1);
						else
							visited[nr][nc] = visited[now.r][now.c];
						q.offer(new Node1261(nr, nc, 0));
//					}
				}
			}
		}
		
		return 0;
	}
	
}

class Node1261{
	int r, c;
	int wall;		//벽 뚫은 개수
	
	public Node1261(int r, int c, int wall) {
		this.r = r;
		this.c = c;
		this.wall = wall;
	}
}

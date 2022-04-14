package 이코테;

import java.util.LinkedList;
import java.util.Queue;

public class dfs {

	static int[] dr = {-1, 1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int n, m, ans = 0;
	static boolean[][] visited;
	static int[][] map = { {0, 0,0,0,0,0,0},
			{0, 1,0,1,0,1,0},
			{0, 1,1,1,1,1,1},
			{0, 0,0,0,0,1,1},
			{0, 1,1,1,1,1,1},
			{0, 1,1,1,1,1,1}};
	
	public static void main(String[] args) {
		n = 5;
		m = 6;
		visited = new boolean[n][m];
		
		bfs(1,1);
		System.out.println(map[n][m]);
	}
	
	public static void bfs(int r, int c) {
		Queue<Node> q = new LinkedList<Node>();
		q.offer(new Node(r, c));
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			
			if(node.r == n && node.c == m)
				return;
			
			for(int i = 0; i < 4; i++) {
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];
				
				if(nr>0 && nr <= n && nc > 0 && nc <= m) {
					if(map[nr][nc] == 1) {
						q.offer(new Node(nr, nc));
						map[nr][nc] += map[node.r][node.c];
					}
				}
			}
			
		}
		
	}

}

class Node {
	int r, c;
	Node(int r, int c){
		this.r = r;
		this.c = c;
	}
}

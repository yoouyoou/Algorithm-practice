package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//보급로
public class s_1249 {

	static int[] dr = {-1, 1, 0 , 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		int idx = 1;
		
		for(int t = 0; t < testcase; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split("");
				
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(str[j]);
			}
			
			System.out.println("#" + idx++ + " " + solution(map));
		}
	}
	
	public static int solution(int[][] map) {
		int ans = Integer.MAX_VALUE;
		int N = map.length;
		int[][] visited = new int[N][N];
		for(int i = 0; i < N; i++)
			Arrays.fill(visited[i], -1);
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.r == N-1 && cur.c == N-1) 
				ans = Math.min(visited[N-1][N-1], ans);
			
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N ) {	//격자 내이고
					//방문 전이고 || 기존방문 값보다 작을경우만
					if(visited[nr][nc] == -1 || visited[nr][nc] > map[nr][nc] + visited[cur.r][cur.c]) {
						visited[nr][nc] = map[nr][nc] + visited[cur.r][cur.c];
						q.add(new Node(nr, nc));
					}
				}
			}
		}
		
		return ans;
	}

}

class Node{
	int r, c;
	
	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

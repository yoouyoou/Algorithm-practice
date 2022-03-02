package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로 탐색
public class b_2178 {

	static int N, M;
	static int[][] maze;
	static int[][] visited;
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maze = new int[N+1][M+1];
		visited = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String[] s= br.readLine().split("");
			for(int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		bfs();
		System.out.println(visited[N][M]);
	}
	
	public static void bfs() {
		Queue<pos> q = new LinkedList<>();
		q.add(new pos(1, 1));
		visited[1][1] = 1;
		
		while(!q.isEmpty()) {
			pos p = q.poll();
			int r = p.r;
			int c = p.c;
			
			/*System.out.println("현재 위치: " + r + "," + c);
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++)
					System.out.print(visited[i][j]);
				System.out.println();
			}*/
			
			if(r == N && c == M)
				return;
			
			for(int i = 0; i < 4; i++) {
				int nextR = r + dr[i];
				int nextC = c + dc[i];
				if(nextR > 0 && nextR <= N && nextC > 0 && nextC <= M) {
					if(visited[nextR][nextC] == 0 && maze[nextR][nextC] == 1) {
						q.add(new pos(nextR, nextC));
						visited[nextR][nextC] = visited[r][c] + 1;
					}
				}
			}	
		}
		
	}

}

class pos{
	int r, c;
	public pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

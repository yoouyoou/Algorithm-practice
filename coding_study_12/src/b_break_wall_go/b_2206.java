package b_break_wall_go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 5 6
010000
111110
000110
000010
111000
-> 이거 답 10일껄
 */

//골드4
public class b_2206 {
	
	static int[] dx = {-1, 1, 0, 0};	//상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int[][] map, visited;
	static int N, M, answer = 0;
	static boolean wall = false; 	//아직 안깸

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				//visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		answer = bfs(0, 0);
		System.out.println(answer);
		br.close();
	}
	
	// N x M
	//visited : 0-미방문, 1-방문, 2-벽뚫었음	->누적 공사 횟수
	//map : 거리저장
	public static int bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 1, 0));
		visited[y][x] = 0;
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			System.out.println("대체 큐에서 뭐가 나온거야: " + point.x + " " + point.y);
			//도착지점
			if(point.x == M-1 && point.y == N-1)
				return point.dist;
			
			for(int i = 0; i < 4; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				
				if(nx >= 0 && nx < M && ny >= 0 && ny < N) {
					if(visited[ny][nx] == 0) {	//미방문
						if(map[ny][nx] == 0) {	//벽이 아닐경우
							q.add(new Point(nx, ny, point.dist+1, point.wall));	//다음좌표 큐에 넣고 거리증가
							visited[ny][nx] = point.wall;
						}
						else {					//벽일 경우
							if(point.wall == 0) {
								q.add(new Point(nx, ny, point.dist+1, point.wall+1));
								visited[ny][nx] = point.wall+1;
							}
						}
					}
				}
			}	
		}
		return -1;
	}

	static class Point{
		int x, y, dist;
		int wall;
		
		public Point(int x, int y, int dist, int wall) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.wall = wall;
		}
	}
	
}

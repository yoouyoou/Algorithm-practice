package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//�� �μ��� �̵��ϱ�
public class b_2206 {
	
	static int[] dx = {-1, 1, 0, 0};	//�����¿�
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		//�Է� �ޱ�
		for(int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
		
		System.out.println(bfs());
		br.close();
	}
	
	//visited[0]: ���ȶվ���, visited[1]: ���վ���
	public static int bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(0, 0, 1, false));
		visited[0][0][0] = true; 
		
		/*		ť �ݺ��� ����		*/
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			if(now.x == N-1 && now.y == M-1)
				return now.dist;
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nd = now.dist + 1;
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					//���� �ƴ� ���
					if(map[nx][ny] == 0) {
						if(now.wall == false && visited[nx][ny][0] == false) {
							q.add(new Point(nx, ny, nd, false));
							visited[nx][ny][0] = true;
						}
						if(now.wall == true && visited[nx][ny][1] == false) {
							q.add(new Point(nx, ny, nd, true));
							visited[nx][ny][1] = true;
						}
					}
					//���� ���
					else {
						if(now.wall == false) {
							q.add(new Point(nx, ny, nd, true));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}
		/*		ť �ݺ��� ��		*/
		return -1;
	}
	
	static class Point{
		int x, y, dist;
		boolean wall;		//������-true, ���ȶ���-false
		
		public Point(int x, int y, int dist, boolean wall) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.wall = wall;
		}
	}

}

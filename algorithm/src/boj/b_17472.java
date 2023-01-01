package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//다리 만들기2
public class b_17472 {

	static int[] dr = {1, -1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int[][] map, bridge;
	static boolean[][] visited;
	static int[] parent;
	static int N, M, island;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		visited = new boolean[N][M];
		
		//input
		for(int i = 0; i < N; i ++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
		
		//섬 나누기
		island = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j] && map[i][j] != 0)
					dfs(i, j, island++);
			}
		}
		
		/* 섬 네이밍 확인 */
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++)
//				System.out.print(map[i][j] + " ");
//			System.out.println();
//		}
		
		bridge = new int[island][island];
		for(int i = 1; i < island; i++)
			Arrays.fill(bridge[i], N+M);
		
		//섬 간 최소 다리수 구하기
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(map[i][j] != 0)
					bfs(i, j, map[i][j]);
		
		/*브릿지 간 최소 다리 수 확인*/
//		for(int i = 1; i < island; i++) {
//			for(int j = 1; j < island; j++)
//				System.out.print(bridge[i][j] + " ");
//			System.out.println();
//		}
		
		System.out.println(kruskal());
		
	}
	
	/* 각 섬을 잇는 다리의 최소값 구하기 */
	public static void bfs(int r, int c, int island) {
		Queue<Point> q = new LinkedList<Point>();
		visited = new boolean[N][M];
		
		for(int i = 0; i < 4; i++) {	//4가지 방면에 대해
			q.offer(new Point(r, c, 0));
			visited[r][c] = true;
			
			while(!q.isEmpty()) {		//한 방향으로 계속 큐에 넣으면서 진행함
				Point now = q.poll();
				
				if(map[now.r][now.c] != 0 && map[now.r][now.c] != island) { //다른 지역 도착했고, 그 지역이 출발 지역이 아님
					if(now.count-1 >= 2)	//다리길이가 2 이상이고
						bridge[island][map[now.r][now.c]] = Math.min(bridge[island][map[now.r][now.c]], now.count-1);

					break;		//이미 한 방향으로 쭉 와서 다른 지역을 만났을 때는 그 좌표값은 끝난거임 이때 다른 방향으로도 나갈 수 있으니 break
				}
					
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] != island) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, now.count+1));
					}
				}
			}
		}
	}
	
	/* 섬 네이밍  */
	public static void dfs(int r, int c, int num) {
		visited[r][c] = true;
		map[r][c] = num;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M)
				if(!visited[nr][nc] && map[nr][nc] != 0)
					dfs(nr, nc, num);
		}
	}

	/* 모든 섬을 잇는 최소의 다리비용 (크루스칼 알고리즘) */
	public static int kruskal() {
		ArrayList<Edge> edges = new ArrayList<>();	//간선 리스트
		int result = 0;	//최종 비용
		
		parent = new int[island];
		for(int i = 1; i < island; i++)	//모든 정점의 부모를 자기 자신으로 초기화
			parent[i] = i;
		
		//모든 간선 입력 받기
		for(int i = 1; i < island; i++) {
			for(int j = 1; j < island; j++) {
				if(bridge[i][j] != N+M) 
					edges.add(new Edge(bridge[i][j], i, j));
			}
		}
		
		Collections.sort(edges);	//간선 비용순 정렬
		
		for(int i = 0; i < edges.size(); i++) {
			int cost = edges.get(i).dist;
			int a = edges.get(i).n1;
			int b = edges.get(i).n2;
			if(findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
		}
		
		//모든 섬이 연결이 안된 경우 처리 ex) 1-2-3, 4
		int rx = 1; //parent[1]
		for(int i = 2; i < island; i++)
			if(rx != findParent(parent[i]))
				return -1;
		
		if(result == 0) result = -1;
		return result;
	}
	
	public static int findParent(int x) {
		if(x == parent[x])
			return x;
		parent[x] = findParent(parent[x]);
		return parent[x];
	}
	
	public static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}

}

class Point{
	int r, c, count;
	
	public Point(int r, int c, int count) {
		this.r = r;
		this.c = c;
		this.count = count;
	}
}

class Edge implements Comparable<Edge>{
	int dist, n1, n2;
	
	public Edge(int dist, int n1, int n2) {
		this.dist = dist;
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override
	public int compareTo(Edge arg0) {
		if(this.dist < arg0.dist)
			return -1;
		return 1;
	}
	
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//최소비용 구하기(다익스트라)
public class b_1916 {
	
	static int N;
	static int[][] cost;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int INF = 100_000_000;
		N = Integer.parseInt(br.readLine());	//도시 개수(노드)
		int M = Integer.parseInt(br.readLine());	//버스 개수(간선)
		
		cost = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		
		//초기화
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j)
					cost[i][j] = 0;
				else
					cost[i][j] = INF; 
			}
		}
		
		for(int i = 1; i <= N; i++)
			dist[i] = INF;
		
		for(int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c= Integer.parseInt(str[2]);
			cost[a][b] = Math.min(c, cost[a][b]);
		}
		
		String[] str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		
		for(int i = 1; i <= N; i++)
			dist[i] = cost[start][i];
		visited[start] = true;
		
		//다익스트라
		for(int i = 0; i < N-1; i++) {	//시작 노드 제외한 나머지 노드 개수만큼 반복(각각을 거쳐가는 경우에 대한 dist배열을 만들어야 하기 때문에)
			int cur = getMinIdx();	//인접한 노드 중 가장 적은비용의 노드 가져오기
			visited[cur] = true;
			
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && dist[j] > dist[cur] + cost[cur][j])
					dist[j] = dist[cur] + cost[cur][j];
			}	
		}
		
		System.out.println(dist[end]);
					
	}
	
	public static int getMinIdx() {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		
		for(int i = 1; i <= N; i++) {
			if(dist[i] < min && !visited[i]) {
				min = dist[i];
				idx = i;
			}
		}
		
		return idx;
	}

}
package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class b_11724 {

	static ArrayList[] g;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int N = sc.nextInt();
		int M = sc.nextInt();
		g = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i <= N; i++)
			g[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			g[u].add(v);
			g[v].add(u);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		
		System.out.println(answer);

	}
	
	public static void dfs(int x) {
		visited[x] = true;
		
		for(int i = 0; i < g[x].size(); i++) {
			int cur = (int) g[x].get(i);
			if(!visited[cur])
				dfs(cur);
		}
	}

}

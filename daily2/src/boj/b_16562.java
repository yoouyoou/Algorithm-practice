package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//친구비
public class b_16562 {

	static int[] parent, A, cost;
	static boolean[] visited;
	static int minCost = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);	//학생 수
		int M = Integer.parseInt(str[1]);	//친구관계 수
		int k = Integer.parseInt(str[2]);	//가지고 있는 돈
		int ans = 0;
		
		A = new int[N+1];
		visited = new boolean[N+1];
		parent = new int[N+1];
		cost = new int[N+1];
		
		str = br.readLine().split(" ");
		
		for(int i = 1; i <= N; i++)
			parent[i] = i;			//부모노드 초기화
		
		for(int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(str[i-1]);	//친구비
		
		Arrays.fill(cost, 10001);
		
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int v = Integer.parseInt(str[0]);
			int w = Integer.parseInt(str[1]);
			
			union(v, w);
		}
		
		for(int i = 1; i <= N; i++) {
			int p = find(i);
			cost[p] = Math.min(cost[p], A[i]);
		}
		
		for(int i = 1; i <= N; i++) {
			if(cost[i] != 10001) {
				ans += cost[i];
				System.out.println(cost[i] + "더함");
			}
			else if(i != parent[i])
				continue;
			else {
				ans += A[i];
				System.out.println(A[i] + "기본값 더함");
			}
		}
		
		if(ans <= k) 
			System.out.println(ans);
		else
			System.out.println("oh no");
	}

	public static void union(int x, int y) {
		//int minCost = Math.min(A[x], A[y]);
		x = find(x);
		y = find(y);

		if(x < y) {
			parent[y] = x;
			//cost[x] = Math.min(cost[x], minCost);
		}
		else {
			parent[x] = y;
			//cost[y] = Math.min(cost[y], minCost);
		}
	}

	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
}

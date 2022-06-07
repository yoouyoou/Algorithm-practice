package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//친구비
public class b_16562 {

	static int[] parent, A;
	static boolean[] visited;
	static int minCost = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);	//학생 수
		int M = Integer.parseInt(str[1]);	//친구관계 수
		int k = Integer.parseInt(str[2]);	//가지고 있는 돈
		
		Friend[] arr = new Friend[M];
		int ans = 0;
		boolean flag = false;
		
		visited = new boolean[N+1];
		parent = new int[N+1];
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		str = br.readLine().split(" ");
		A = new int[N+1];
		for(int i = 1; i <= N; i++)
			A[i] = Integer.parseInt(str[i-1]);	//친구비
		
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int v = Integer.parseInt(str[0]);
			int w = Integer.parseInt(str[1]);
			
			arr[i] = new Friend(v, w);		
		}
		
		Arrays.sort(arr);
		
		for(int i = 0; i < M; i++) {
			int v = arr[i].x;
			int w = arr[i].y;
			
			if(visited[v] == false && visited[w] == false) {
				if(i == M-1) {
					ans += Math.min(A[v], A[w]);
					break;
				}
				
				if(flag)
					ans += minCost;

				minCost = Math.min(A[v], A[w]);
				visited[v] = true;
				visited[w] = true;
				flag = true;
			}
			else {
				visited[v] = true;
				visited[w] = true;
				
				minCost = Math.min(minCost, Math.min(A[v], A[w]));
				
				if(i == M-1) {
					ans += minCost;
					break;
				}
				flag = true;
			}	
			
		}
		
		for(int i = 1; i <= N; i++)
			if(visited[i] == false)
				ans += A[i];
		
		if(ans <= k)
			System.out.println(ans);
		else
			System.out.println("oh no");
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y)
			return;
		if(x < y) {
			parent[y] = x;
		}
		else parent[x] = y;
	}

	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
}

class Friend implements Comparable<Friend>{
	int x, y;
	
	public Friend(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Friend arg0) {
		if(x > arg0.x && x > arg0.y)
			return 1;
		else if(y > arg0.x && y > arg0.y)
			return 1;
		else
			return -1;
	}
}

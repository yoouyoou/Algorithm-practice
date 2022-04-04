package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 트리의지름 {

	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int node, max = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<Node>();
		
		//input
		for(int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			int t = 0;
			int v1 = Integer.parseInt(str[t++]);
			while(true) {
				if(str[t].equals("-1"))
					break;
				int v2 = Integer.parseInt(str[t++]);
				int cost = Integer.parseInt(str[t++]);
				list[v1].add(new Node(v2, cost));
			}
		}
		
		//solution
		visited = new boolean[n+1];
		dfs(1, 0);	//1과 가장 먼 노드
		
		visited = new boolean[n+1];
		dfs(node, 0);
		
		System.out.println(max);
		br.close();
	}
	
	public static void dfs(int x, int len) {
		if(len > max) {
			max = len;
			node = x;
		}
		
		visited[x] = true;
		
		for(int i = 0; i < list[x].size(); i++) {
			Node n = list[x].get(i);
			if(!visited[n.v]) {
				dfs(n.v, n.cost + len);
			}
		}
	}

}

class Node{
	int v, cost;
	
	public Node(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}
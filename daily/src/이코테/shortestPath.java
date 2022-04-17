package 이코테;

import java.util.ArrayList;

public class shortestPath {

	static ArrayList<ArrayList<Node2>> g;
	static int city = 0;
	static int time = 0;
	
	public static void main(String[] args) {
		int N = 3;	//도시개수
		int M = 2;	//통로개수
		int C = 1;	//시작 정점
		
		g = new ArrayList<ArrayList<Node2>>();
		for(int i = 0; i <= N; i++)
			g.add(new ArrayList<Node2>());
		
		g.get(1).add(new Node2(2, 4));
		g.get(1).add(new Node2(3, 2));

		dfs(C);
		System.out.println(city + " " + time);
	}
	
	public static void dfs(int start) {
		int max = 0;
		
		for(int i = 0; i < g.get(start).size(); i++) {
			Node2 n = g.get(start).get(i);
			max = Math.max(max, n.cost);
			city++;
			dfs(n.node);
		}
		time += max;
	}

}

class Node2{
	int node, cost;
	public Node2(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
}
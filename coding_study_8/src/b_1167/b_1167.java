package b_1167;

import java.util.ArrayList;
import java.util.Scanner;

//트리의 지름, 골드3
public class b_1167 {

	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int V;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for(int i = 1; i <= V; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < V; i++) {
			int u = sc.nextInt();
			while(true) {
				int v = sc.nextInt();
				if(v == -1)
					break;
				int w = sc.nextInt();
				list[u].add(new Node(v,w));
			}
		}
		
		int max = 0;
		for(int i = 1; i <= V; i++) {
			int temp = DFS(i, 0);
			if(max < temp)
				max = temp;
		}
			
		System.out.println(max);
		sc.close();
		
		/*값 받은거 확인해본거
		for(int i = 1; i <= V; i++) {
			for(Node j : list[i])
				System.out.print(j.weight + " ");
			System.out.println();
		}*/

	}

	public static int DFS(int x, int total) {
		if(visited[x]) {
			System.out.println("이미 방문! return:  " + 0);
			return 0;
		}
		visited[x] = true;
		
		for(Node n : list[x]) {
			System.out.println("자식 노드! return:  " + n.weight);
			return DFS(n.node, total + n.weight);
		}
		
		System.out.println("방문 끝! return:  " + 0);
		//visited = new boolean[V+1];
		return total;
	}
	
	// 정점,비용의 노드객체
	public static class Node{
		int node, weight;
		
		public Node(int n, int w) {
			this.node = n;
			this.weight = w;
		}
	}
}

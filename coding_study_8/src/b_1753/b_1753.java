package b_1753;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//최단경로 (골드5)
public class b_1753 {
	
	static ArrayList<Node>[] list;
	static int dist[];
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int startV = sc.nextInt();
		
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		dist = new int[V+1];
		
		Arrays.fill(dist, -1); 	//dist배열 -1로 채우기
		dist[startV] = 0;		// 시작 정점
		
		for(int i = 1; i <= V; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			list[u].add(new Node(v, w));
		}
		
		/*for(int i = 1; i <= V; i++) {
			for(Node j : list[i])
				System.out.print(j.node + " ");
			System.out.println();
		}*/
		
		
		Dijkstra(startV);
		for(int i = 1; i <= V; i++) {
			if(dist[i] == -1)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}
		
	}
	
	static void Dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(start, 0)); //값 추가
		//dist[start] = 0;
		
		while(!q.isEmpty()) {
			Node now = q.poll();	// 큐의 첫번째 값 반환후 제거
			if(visited[now.node])
				continue;
			
			visited[now.node] = true;
			for(Node next : list[now.node]) {
				if(dist[next.node]==-1 || dist[next.node] > dist[now.node]+next.weight) {
					dist[next.node] = dist[now.node] + next.weight;
					q.add(new Node(next.node, dist[next.node]));
				}
			}
		}
		
		/*
		while(!q.isEmpty()) {
			Node now = q.poll();	//큐의 첫번째 값 반환후 제거
			if(!visited[now.node]) {
				visited[now.node] = true;
				for(Node next : list[now.node]) {
					if(dist[next.node]==-1 || dist[next.node] > dist[now.node]+next.weight) {
						dist[next.node] = dist[now.node] + next.weight;
						q.offer(new Node(next.node, dist[next.node]));
					}
				}
			}
		}*/
	}
	
	private static class Node implements Comparable<Node>{
		int node, weight;
		
		Node(int n, int w){
			this.node = n;
			this.weight = w;
		}
		
		public int compareTo(Node n) {
			return weight - n.weight;
		}
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//최소비용 구하기2
public class b_11779 {

	static ArrayList<Node>[] list;
	static int[] d;
	static ArrayList<Integer> path; //최소비용을 갖는 경로에 포함되어 있는 도시
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		path = new ArrayList<>();
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Node>();
		
		d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		for(int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int cost = Integer.parseInt(str[2]);
			list[a].add(new Node(b, cost));
		}
		
		String[] str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		
		path.add(start);
		dijkstra(start, end);
		path.add(end);
		
		System.out.println(d[end]);
		System.out.println(path.size());
		for(int p: path)
			System.out.print(p + " ");
		
	}
	
	public static void dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		d[start] = 0;	//자기자신 거리 = 0
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();	//최소힙이므로 가장 거리가 짧은 노드 꺼내기
			int dist = node.cost;
			int now = node.node;
//			System.out.println(now + "번 노드");
			
			if(d[now] < dist)	//이미 처리된 적 있는 노드라면
				continue;
			
			for(int i = 0; i < list[now].size(); i++) {
				int cost = d[now] + list[now].get(i).cost;
				
				if(cost < d[list[now].get(i).node]) {
					if(list[now].get(i).node == end && now != start) 	//end노드가 갱신되면
						path.add(now);					//갱신시키는 노드 넣기

					d[list[now].get(i).node] = cost;
					pq.offer(new Node(list[now].get(i).node, cost));
				}
			}
			
		}

	}

}

class Node implements Comparable<Node>{
	int node, cost;
	
	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node arg0) {
		return arg0.cost - this.cost;
	}
}

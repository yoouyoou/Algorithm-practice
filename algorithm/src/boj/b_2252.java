package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//줄 세우기
public class b_2252 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] indegree = new int[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);	//
			indegree[b]++;	//진입차수 증가
		}
		
		for(int i = 1; i <= N; i++)
			if(indegree[i] == 0)	//우선순위
				q.offer(i);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");	//진입차수 없는 거 꺼내기
			
			//해당 원소를 처리함으로써 갈 수 있는 원소 구해서 큐에 넣기
			for(int i = 0; i < list[now].size(); i++) {
				indegree[list[now].get(i)]--;		//다른 원소의 진입차수 개수 하나 내리기
				
				if(indegree[list[now].get(i)] == 0)	//만약 진입차수가 0이면
					q.offer(list[now].get(i));		// 다시 넣기
			}
		}
		
		sc.close();
	}

}

package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_18352 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int X = sc.nextInt();
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int[] dist = new int[N+1];	// X에서 각 도시로 갈 수 있는 거리
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if(map.containsKey(x))
				map.get(x).add(y);
			else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(y);
				map.put(x, list);
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(dist, -1);		// 방문여부 체크할 수 있는 값
		q.offer(X);					// 시작점 넣기
		dist[X] = 0;				// 본인거리 = 0
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(map.containsKey(now)) {
				for(int city: map.get(now)) {
					if(dist[city] == -1) {
						dist[city] = dist[now] + 1;
						q.offer(city);
					}
				}
			}
		}
		
		// dist배열 체크
		boolean flag = false;
		for(int i = 1; i <= N; i++) {
			if(dist[i] == K) {
				System.out.println(i);
				flag = true;
			}
		}
		
		if(!flag)
			System.out.println(-1);
	}
	
}

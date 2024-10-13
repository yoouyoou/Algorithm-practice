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
		int[] dist = new int[N+1];	// X���� �� ���÷� �� �� �ִ� �Ÿ�
		
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
		Arrays.fill(dist, -1);		// �湮���� üũ�� �� �ִ� ��
		q.offer(X);					// ������ �ֱ�
		dist[X] = 0;				// ���ΰŸ� = 0
		
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
		
		// dist�迭 üũ
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

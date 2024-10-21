package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class b_2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		
		int answer = 0;
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer> list[] = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < S; i++) {
			String[] str = br.readLine().split(" ");
			int num1 = Integer.parseInt(str[0]);
			int num2 = Integer.parseInt(str[1]);
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i : list[cur]) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
			
			answer++;
		}
		
		System.out.println(answer - 1);
	}

}

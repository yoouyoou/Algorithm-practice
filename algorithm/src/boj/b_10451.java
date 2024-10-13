package boj;

import java.util.Scanner;

public class b_10451 {

	static int answer;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int N;
		
		for(int i = 0; i < testcase; i++) {
			N = sc.nextInt();
			arr = new int[N+1];
			visited = new boolean[N+1];
			answer = 0;
			
			for(int j = 1; j <= N; j++)
				arr[j] = sc.nextInt();
			
			for(int k = 1; k <= N; k++)
				if(!visited[k]) {
					//System.out.println();
					DFS(k);
				}
			
			System.out.println(answer);
		}
	}
	
	public static void DFS(int i) {
		//System.out.print(i + " -> ");
		
		if(visited[i]) {
			answer++;
			return;
		}
		
		visited[i] = true;
		DFS(arr[i]);
	}

}

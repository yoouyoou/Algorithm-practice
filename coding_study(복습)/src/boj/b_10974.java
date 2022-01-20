package boj;

import java.util.Scanner;

//모든 순열
public class b_10974 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] result = new int[N+1];
		boolean[] visited = new boolean[N+1];
		permutation(N, 1, result, visited);
		sc.close();
	}
	
	public static void permutation(int n, int depth, int[] result, boolean[] visited) {
		/*System.out.println(depth + "번째 순열 상황");
		for(int i = 1; i < n+1; i++)
			System.out.print(result[i] + " ");
		System.out.println();*/
		
		if(depth == n+1) {
			for(int i = 1; i < n+1; i++)
				System.out.print(result[i]);
			System.out.println();
			return;
		}
		
		for(int i = 1; i < n+1; i++) {
			if(visited[i] == false) {
				result[depth] = i;
				visited[i] = true;
				permutation(n, depth+1, result, visited);
				visited[i] = false;
			}
		}
		
	}

}

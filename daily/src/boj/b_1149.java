package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// RGB거리
public class b_1149 {

	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] cost;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		boolean[] rgb = new boolean[3];
		
		//각 RGB칠하는 비용
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < 3; j++)
				cost[i][j] = Integer.parseInt(str[j]);
		}
		
	}
	
	public static void dfs(int depth, int[] arr, boolean[] visited, boolean[] rgb) {
		if(depth == N) {
			if(arr[depth] < min)
				min = arr[depth];
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				if(!rgb[j]) {
					rgb[j] = true;
					arr[depth] = cost[i][j];
					visited[i] = true;
					dfs(depth+1, arr, visited, rgb);
					visited[i] = false;
					rgb[j] = false;
				}
			}
		}
		
	}

}

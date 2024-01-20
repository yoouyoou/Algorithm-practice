package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1311 {

	static int N, Min = Integer.MAX_VALUE;
	static int[][] cost;
	static boolean[] visited;
	static int[] output;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][N];
		visited = new boolean[N];
		output = new int[N];
		
		for(int i =  0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		perm(0, 0);
		
		System.out.println(Min);
	}
	
	//depth == work
	public static void perm(int depth, int total) {
		if(depth == N) {
			print(output);
			System.out.println("->" + total + "\n");
			Min = Math.min(Min, total);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[depth] = i;	//어떤 사람이 들어가는지 확인용
				perm(depth + 1, total + cost[i][depth]);
				visited[i] = false;
//				total -= cost[i][depth];
			}
		}
	}
	
	static void print(int[] arr) {
        for (int i = 0; i < N; i++)
            System.out.print(arr[i] + " ");
        //System.out.println();
    }

}

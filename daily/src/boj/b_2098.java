package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//외판원 순회
public class b_2098 {

	static int[][] w;
	static int N;
	static boolean[] visited;
	static int ans = 0, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		visited = new boolean[N];
				
		//input
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				w[i][j] = Integer.parseInt(str[j]);
		}
		
		//solution
		dfs(0, 1);	//0번 도시부터 방문시작
		System.out.println(min);
	}
	
	public static void dfs(int x, int num) {
		System.out.print("현재 방문 도시: " + x + " ("+num+"번째)");
		
		if(num == N) {	//모두 방문이 완료되었음
			if(min > ans + w[x][0]) {
				min = ans + w[x][0];
//				System.out.println("min값: " + min + "갱신!");
			}
			return;
		}
		
		visited[x] = true;	//방문 표시
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && w[x][i] != 0 && i != x) {	//방문안함
//				System.out.println("-> " + i);
				ans += w[x][i];
				dfs(i, num+1);
				visited[i] = false;
				ans -= w[x][i];
			}
		}
		visited[x] = false;
		return;
	}

}

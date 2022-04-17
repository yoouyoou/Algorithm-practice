package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//야바위 게임
public class b_23741 {

	static ArrayList<Integer>[] g;
	static boolean[][] dp;
	static int[] answer;
	static int Y, idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);	//정점개수
		int M =  Integer.parseInt(str[1]);	//간선 수
		int X =  Integer.parseInt(str[2]);	//공 처음정점
		Y =  Integer.parseInt(str[3]);	//공 움직임 횟수
		
		g = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++)
			g[i] = new ArrayList<Integer>();

		dp = new boolean[1111][1111];
		answer = new int[1111];
		
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			g[a].add(b);
			g[b].add(a);
		}
		
		dfs(X, 0);
		
		if(answer[0] == 0)
			System.out.println("-1");
		else {
			Arrays.sort(answer, 0, idx);
			for(int i = 0; i < idx; i++)
				System.out.print(answer[i] + " ");
		}
		
	}

	public static void dfs(int node, int total) {
		
		dp[node][total] = true;	//현재 이 노드에서 total개수를 가지고 갈 수 있는 경우는 다 봤다
		
		if(total == Y) {
			answer[idx++] = node;
			return;
		}
		
		//시작 노드에 연결된 개수만큼 돌면서
		for(int i = 0; i < g[node].size(); i++) {
			int nextNode = g[node].get(i);	//연결된 다른 노드
			
			if(!dp[nextNode][total+1])
				dfs(nextNode, total+1);
		}
		
		return;
	}

}

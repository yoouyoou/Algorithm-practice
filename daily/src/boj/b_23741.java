package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//야바위 게임
public class b_23741 {

//	static ArrayList<ArrayList<Integer>> g;
	static ArrayList<Integer>[] g;
	static Set<Integer> answer;
	static boolean[] dp;
	static boolean isCheck = false;
	static int Y;
	
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
//		g = new ArrayList<ArrayList<Integer>>();
		
		answer = new HashSet<Integer>();
		dp = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			g[a].add(b);
			g[b].add(a);
		}
		
		dfs(X, 0);
		if(!isCheck)
			System.out.println("-1");
//		if(answer.size() == 0)
//			System.out.println("-1");
//		else {
//			for(int a: answer)
//				System.out.print(a + " ");
//		}
	}

	public static void dfs(int node, int total) {
		if(total == Y) {
			if(!dp[node]) {
				System.out.print(node+ " ");
				dp[node] = true;
				isCheck = true;
			}
			
			return;
		}
		
		//시작 노드에 연결된 개수만큼 돌면서
		for(int i = 0; i < g[node].size(); i++) {
			int nextNode = g[node].get(i);	//연결된 다른 노드
			dfs(nextNode, total+1);
		}
		
		return;
	}
	
//	public static void dfs2(int node, int total) {
//		if(total == Y) {
//			dp[node] = total;
//			answer.add(node);
//			return;
//		}
//		
//		//시작 노드에 연결된 개수만큼 돌면서
//		for(int i = 0; i < g[node].size(); i++) {
//			int nextNode = g[node].get(i);	//연결된 다른 노드
//			if(dp[nextNode] != 0)
//			dfs(nextNode, total+1);
//		}
//		
//		return;
//	}

}

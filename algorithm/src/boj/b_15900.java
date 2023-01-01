package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//나무 탈출
public class b_15900 {

	static int N, total = 0;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		visited = new boolean[N+1];
//		Arrays.fill(visited, -1);
		
		StringTokenizer st;
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}	
		
		visited[1] = true;
		dfs(1, 0);
		
		//짝수-짐, 홀수-이김
		String answer = (total % 2) == 0? "No" : "Yes";
		System.out.println(answer);
	}
	
	public static void dfs(int x, int sum) {
		
		for(int i = 0; i < list[x].size(); i++) {
			if(visited[list[x].get(i)] == false) {
				visited[list[x].get(i)] = true;
				dfs(list[x].get(i), sum+1);
			}
		}
		
		if(list[x].size() == 1)
			total += sum;
	}
	
	/*
	public static void dfs(int x) {
		
		for(int i = 0; i < list[x].size(); i++) {
			if(visited[list[x].get(i)] == -1) {			//다음 노드가 방문되지 않았으면
				visited[list[x].get(i)] = visited[x] + 1;		//방문표시 후
//				System.out.println(x + "에서 " + tree[x].get(i) + "간다");
				dfs(list[x].get(i));				//그 노드로 다시 dfs진행
			}
		}
		
		//인접 리스트 사이즈가 1이면 부모로 연결된 노드 하나이므로 리프노드다
		if(list[x].size() == 1)
			total += visited[x];

	}
	*/
		
}

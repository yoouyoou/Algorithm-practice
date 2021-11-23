package b_BFSDFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_1260 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 정점 개수
		int M = sc.nextInt();	// 간선 개수
		int V = sc.nextInt();	// 시작 정점
		
		list = new ArrayList[N+1];	// ArrayList배열 초기화. 정점의 번호대로 인덱스를 맞추기 위해 N+1 크기로 생성
		
		for(int i = 1; i < N+1; i++)//
			list[i] = new ArrayList<Integer>();//
		
		for(int i = 0; i < M; i++) {//
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		//작은 정점부터 차례차례 방문하므로 정렬 필요
		for(int i = 1; i < N+1; i++)
			Collections.sort(list[i]);	// ArrayList정렬 메소드
		
		visited = new boolean[N+1]; // 정점 방문여부를 위해 정점 개수와 맞게 배열 생성 : boolean의 초기 생성값은 false
		DFS(V);						// 시작 정점부터 깊이우선탐색 시작
		System.out.println();
		
		visited = new boolean[N+1]; // 방문배열 다시 초기화
		BFS(V);						// 시작 정점부터 너비우선 탐색 시작
		
		sc.close();
	}
	
	static void DFS(int x) {
		if(visited[x])	
			return;		// 이미 방문한 곳이라면 바로 리턴
		
		visited[x] = true;	// 아니면 방문했다고 표시
		System.out.print(x + " ");
		
		for(int y : list[x])	// 방문 정점과 이어진 다른 정점들 하나하나 확인
			if(!visited[y])		// 아직 방문이 안되었다면
				DFS(y);			// 계속 깊이 이어가기
	}
	
	static void BFS(int x) {
		Queue<Integer> q = new LinkedList<Integer>();	// 큐생성
		q.add(x);	// 정점 큐에 넣기
		visited[x] = true;	// 정점 방문했다고 표시
		
		int n;
		while(!q.isEmpty()) {	// 큐 빌 때까지 반복
			n = q.poll();		// 큐의 첫번째 값 빼내기
			System.out.print(n + " ");	
			
			for(int y : list[n]) {	// 첫번째 방문 정점의 인접한 정점들 확인
				if(!visited[y]) {	// 방문하지 않았다면
					q.add(y);		// 큐에 넣고
					visited[y] = true; // 방문표시
				}
			}
			// 첫번째 정점과 인접한 애들 다 큐에 넣고, 다시 위로 올라가 그 값들 을다시 큐에서 빼내면서 인접한 값의 인접한 애들 큐에 넣기..
		}
		
	}

}

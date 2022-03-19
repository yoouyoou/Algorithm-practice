package boj;

import java.util.Scanner;

//플로이드 워셜
public class b_11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int INF = 100_000_000;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		
		//초기화 작업
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(i == j)
					map[i][j] = 0;
				else
					map[i][j] = INF;
			}
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			map[a][b] = Math.min(map[a][b], c);
		}
		
		//갱신 작업
		for(int k = 1; k <= n; k++) {		//n개의 노드에 대해 각각의 노드를 거쳐가는 경우를 계산
			for(int i = 1; i <= n; i++)	{	//i노드 출발
				if(i == k)
					continue;
				for(int j = 1; j <= n; j++) {	//j노드 도착
					if(k == j)
						continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					//System.out.println("("+i+","+j+")" + map[i][j] + "/ " + map[i][k] + "/ " + map[k][j]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == INF)
					System.out.println("0 ");
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}

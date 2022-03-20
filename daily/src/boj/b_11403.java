package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//경로 찾기(실버1)
public class b_11403 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] G = new int[N+1][N+1];
		
		//input
		for(int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				if(i == j) 
					G[i][j] = 1;
				G[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		//solution
		for(int k = 1; k <= N; k++) {		//k번째 노드를 거쳐 가는 경우
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(G[i][k] == 1 && G[k][j] == 1)
						G[i][j] = 1;
		}
		
		//output
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				System.out.print(G[i][j] + " ");
			System.out.println();
		}
		
	}
	
	//처음 생각했던 것: Set이용하여 해당 행 마다 갈 수 있는 열 모두 넣기 
	//출발 정점 i에서 j를 거칠 수 있을 때 j에서 파생되는 도착 노드들 i행에서 1로 바꾸기
}

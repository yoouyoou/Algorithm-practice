package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//�ּҺ�� ���ϱ�(���ͽ�Ʈ��)
public class b_1916 {
	
	static int N;
	static int[][] cost;
	static int[] dist;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int INF = 100_000_000;
		N = Integer.parseInt(br.readLine());	//���� ����(���)
		int M = Integer.parseInt(br.readLine());	//���� ����(����)
		
		cost = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		
		//�ʱ�ȭ
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j)
					cost[i][j] = 0;
				else
					cost[i][j] = INF; 
			}
		}
		
		for(int i = 1; i <= N; i++)
			dist[i] = INF;
		
		for(int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c= Integer.parseInt(str[2]);
			cost[a][b] = Math.min(c, cost[a][b]);
		}
		
		String[] str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		
		for(int i = 1; i <= N; i++)
			dist[i] = cost[start][i];
		visited[start] = true;
		
		//���ͽ�Ʈ��
		for(int i = 0; i < N-1; i++) {	//���� ��� ������ ������ ��� ������ŭ �ݺ�(������ ���İ��� ��쿡 ���� dist�迭�� ������ �ϱ� ������)
			int cur = getMinIdx();	//������ ��� �� ���� ��������� ��� ��������
			visited[cur] = true;
			
			for(int j = 1; j <= N; j++) {
				if(!visited[j] && dist[j] > dist[cur] + cost[cur][j])
					dist[j] = dist[cur] + cost[cur][j];
			}	
		}
		
		System.out.println(dist[end]);
					
	}
	
	public static int getMinIdx() {
		int min = Integer.MAX_VALUE;
		int idx = 0;
		
		for(int i = 1; i <= N; i++) {
			if(dist[i] < min && !visited[i]) {
				min = dist[i];
				idx = i;
			}
		}
		
		return idx;
	}

}
package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//�ּҺ�� ���ϱ�(���ͽ�Ʈ��)
public class b_1916 {

	static int INF = 100_000_000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int INF = Integer.MAX_VALUE;
		int N = Integer.parseInt(br.readLine());	//���� ����(���)
		int M = Integer.parseInt(br.readLine());	//���� ����(����)
		
		ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		
		//�ʱ�ȭ
		for(int i = 0; i < N; i++)
			g.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c= Integer.parseInt(str[2]);
			g.get(a).add(new Node(b, c));
		}
		
		String[] str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0]);
		int end = Integer.parseInt(str[1]);
		
		//���ͽ�Ʈ��� �����ؾ� ��
		/*�÷��̵� ����
		for(int k = 1; k <= N; k++) {	//���� k��带 ���İ��� ��쿡 ����
			for(int i = 1; i <= N; i++) {
				if(i == k)
					continue;
				for(int j = 1; j <= N; j++) {
					if(j == k)
						continue;
					cost[i][j] = Math.min(cost[i][j], cost[i][k] + cost[k][j]);
				}
			}
		}*/
					
	}

}

class Node{
	int idx;
	int cost;
	
	public Node(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}
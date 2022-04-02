package test;

import java.util.Scanner;

//���ͽ�Ʈ��?
public class Ʈ�������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		int[][] tree = new int[v+1][v+1];
		int[] dist = new int[v+1];
		
		//input
		for(int i = 0; i < v; i++) {
			int v1 = sc.nextInt();
			while(true) {
				int v2 = sc.nextInt();
				if(v2 == -1)
					break;
				int distance = sc.nextInt();
				tree[v1][v2] = distance;
			}
		}

		for(int i = 1; i <= v; i++) {
			dist[i] = Integer.MAX_VALUE;	//�ִ밪���� ����
		}
		
		//solution  ���ͽ�Ʈ��? dp?
		for(int i = 1; i <= v; i++) {
			for(int j = 1; j <= v; j++)
				dist[j] = tree[i][j];
		}
	}
	
	public static void dijkstra() {
		
	}

}

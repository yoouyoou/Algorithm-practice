package boj;

import java.util.Scanner;

//�÷��̵� ����
public class b_11404 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int INF = 100_000_000;
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		
		//�ʱ�ȭ �۾�
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
		
		//���� �۾�
		for(int k = 1; k <= n; k++) {		//n���� ��忡 ���� ������ ��带 ���İ��� ��츦 ���
			for(int i = 1; i <= n; i++)	{	//i��� ���
				if(i == k)
					continue;
				for(int j = 1; j <= n; j++) {	//j��� ����
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

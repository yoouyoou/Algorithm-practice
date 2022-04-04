package test;

import java.util.Scanner;

public class ������ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		//���ð���
		long[] cost = new long[N];	//���ʹ� ����
		long[] dist = new long[N-1];	//���ð� �Ÿ�
		
		//�Ÿ� �Է�
		for(int i = 0; i < N-1; i++)
			dist[i] = sc.nextInt();
		
		//��� �Է�
		for(int i = 0; i < N; i++)
			cost[i] = sc.nextInt();
		
		//solution
		int costIdx = 0;
		long ans = 0;
		long minCost = cost[costIdx];
		for(int i = 0; i < N-1; i++) {
			ans += minCost * dist[i];
			if(minCost > cost[++costIdx])
				minCost = cost[costIdx];
		}

		System.out.println(ans);
		sc.close();
	}

}

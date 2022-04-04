package test;

import java.util.Scanner;

public class 주유소 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		//도시개수
		long[] cost = new long[N];	//리터당 가격
		long[] dist = new long[N-1];	//도시간 거리
		
		//거리 입력
		for(int i = 0; i < N-1; i++)
			dist[i] = sc.nextInt();
		
		//비용 입력
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

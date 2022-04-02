package test;

import java.util.Scanner;

public class 주유소 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		//도시개수
		int[] cost = new int[N];	//리터당 가격
		int[] dist = new int[N-1];	//도시간 거리
		int totalL = 0, answer = 0;
		
		for(int i = 0; i < N-1; i++) {
			dist[i] = sc.nextInt();
			totalL += dist[i];
		}
		
		for(int i = 0; i < N; i++)
			cost[i] = sc.nextInt();
		

	}

}

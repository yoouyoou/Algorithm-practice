package test;

import java.util.Scanner;

public class ������ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		//���ð���
		int[] cost = new int[N];	//���ʹ� ����
		int[] dist = new int[N-1];	//���ð� �Ÿ�
		int totalL = 0, answer = 0;
		
		for(int i = 0; i < N-1; i++) {
			dist[i] = sc.nextInt();
			totalL += dist[i];
		}
		
		for(int i = 0; i < N; i++)
			cost[i] = sc.nextInt();
		

	}

}

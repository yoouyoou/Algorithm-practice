package study;

import java.util.Scanner;

//게임을 만든 동준이
public class 그리디 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int N = sc.nextInt();		//레벨의 수
		int[] score = new int[N];	//각레벨을 클리어하면 얻는 점수
		for(int i = 0; i < N; i++)	
			score[i] = sc.nextInt();
		
		//1 2 3 4단계
		//5 3 7 5
		//5 5 5 
//		for(int i = 0; i < N-1; i++) {
//			if(score[i] >= score[i+1])
//				ans += score[i] - score[i+1] + 1;
//		}
		
		for(int i = N-1; i > 0; i--) {
			if(score[i-1] >= score[i]) {
				int temp = score[i-1] - score[i] + 1;
				ans += temp;
				score[i-1] -= temp;
			}
		}
		
		System.out.println(ans);
	}

}

package boj;

import java.util.Scanner;

//빗물(골드5)
public class b_14719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0, count;
		boolean start = false, end = false;	//블록 시작-true 
		int H = sc.nextInt();
		int W = sc.nextInt();
		int[][] block = new int[H][W];
		
		for(int i = 0; i < W; i++) {
			int rain = sc.nextInt();
			int idx = H-1;
			for(int j = 0; j < rain; j++) {
				block[idx--][i] = 1;
			}
		}
		

		/* 빗물 확인
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++)
				System.out.print(block[i][j]);
			System.out.println();
		}*/
		
		
		for(int i = H-1; i >= 0; i--) {		//맨 아래 줄 부터
			start = false;
			end = false;
			count = 0;
			for(int j = 0; j < W; j++) {	//가로로 빗물 세기
				//블록일 경우
				if(block[i][j] == 1) {
					if(!start)
						start = true;
					else
						end = true;
				}
				//블록이 아닐 경우
				else {
					if(end) {
						end = false;
						answer += count;
						count = 0;
					}
					if(start && !end)
						count++;
				}
			}
			if(!end)
				continue;
			answer += count;
		}
			
		System.out.println(answer);
	}
}

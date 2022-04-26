package test;

import java.util.Scanner;

public class s1_23058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int one = 0, zero = 0;
		int[][] map = new int[N][N];
		
		//input
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				map[i][j] = temp;
				if(temp == 0)
					zero++;
				else
					one++;
			}
		}
		
		//

	}

}

package b_greatTown;

import java.util.Scanner;

public class b_1949 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] town = new int[n][n];
		int[] people = new int[n];
		//int[] towncase = new int[n];
		
		for(int i = 0; i < n; i++)
			people[i] = sc.nextInt();
		
		int a, b;
		for(int i = 0; i < n-1; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			town[a-1][b-1] = 1;
		}
		
		// 2차원 배열 확인
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++)
				System.out.print(town[i][j]);
			System.out.println();
		}
		
		sc.close();
	}

}

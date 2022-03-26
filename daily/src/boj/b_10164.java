package boj;

import java.util.Scanner;

//격자상의 경로(실버1)
public class b_10164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		if(K == 0) {	//꼭 거쳐가지 않아도 되는 경우
			System.out.println(factorial(N + M - 2) / factorial(N-1) / factorial(M-1));
		}
		else {
			int r = K / M + 1;
			int c = K % M;
			//System.out.println(r + " " + c);
			int temp = factorial(c + r - 2) / factorial(c-1) / factorial(r-1);
			int temp2 = factorial(M - c + N - r) / factorial(M-c) / factorial(N-r);
			System.out.println(temp * temp2);
		}
		
		sc.close();
	}
	
	public static int factorial(int n) {
		int rslt = 1;
		
		for(int i = 1; i <= n; i++)
			rslt *= i;
		
		return rslt;
	}

}

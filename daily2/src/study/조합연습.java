package study;

import java.util.Scanner;

public class ���տ��� {
	
	//10872�� ���丮��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
//		int ans = 1;
		
		System.out.println(factorial(N));
		sc.close();
	}
	
	public static int factorial(int N) {
		if(N <= 1)
			return 1;
		return N * factorial(N-1);
	}

}

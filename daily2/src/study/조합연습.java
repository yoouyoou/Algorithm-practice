package study;

import java.util.Scanner;

public class ���տ��� {
	
	//10872�� ���丮��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 1;
		
		for(int i = 1; i <= N; i++) 
			ans *= i;
		
		System.out.println(ans);
		sc.close();
	}

}

package study_DP;

import java.util.Scanner;

public class �Ǻ���ġ�Լ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int zero = 0, one = 0;
		int T = sc.nextInt();	//�׽�Ʈ ���̽� ����
		int[] tarr = new int[T];
		int[][] dp = new int[T][T];
		
		dp[0][0] = 0;
		dp[0][1] = 1;
		for(int i = 0; i < T; i++)
			tarr[i] = sc.nextInt();
		
//		for(int i = 0; i < tarr.length; i++)

	}

}

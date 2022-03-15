package study_DP;

import java.util.Scanner;

public class b_9184 {

	static int [][][] dp = new int[21][21][21];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = 0, b = 0, c = 0;
		String rslt = "";
		
		while(true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(a == -1 && b == -1 && c == -1)
				break;
			rslt += "w("+ a +", " + b + ", " + c + ") = " + w(a,b,c) + "\n";
		}
		
		System.out.println(rslt);
//		System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a,b,c));
		
		sc.close();
	}

	public static int w(int a, int b, int c) {
		if(a <= 0 || b <= 0 || c <= 0)
			return 1;
		
		if(a > 20 || b > 20 || c > 20)
			return w(20, 20, 20);
		
		if(dp[a][b][c] != 0)	//이미 값이 있을 경우(메모이제이션)
			return dp[a][b][c];
		
		//값이 없는 경우
		if(a < b && b < c) {
			dp[a][b][c] = w(a,b,c-1) + w(a, b-1, c-1) - w(a, b-1, c);	//dp저장 후
			return dp[a][b][c];	//값 반환
		}
		
		dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1,b-1,c-1); //문제 조건에 모두 안걸침
		return dp[a][b][c];
		
	}
}

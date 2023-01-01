package study;

import java.util.Scanner;

public class b_1519 {
	
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();		//게임판의 숫자
		dp = new int[N + 1];		//0:모름, 1:이김, -1:짐
		
		if(N < 10)
			System.out.println(-1);
		else {
			for(int i = 0; i < 10; i++)
				dp[i] = -1;
			System.out.println( solution(N) );
		}
		
		sc.close();
	}
	
	public static int solution(int n) {
		//승패가 결정된 경우 바로 리턴
		if(dp[n] != 0)
			return dp[n];
		
		//진 부분 문자열 구하기
		int num = Integer.MAX_VALUE;
		boolean win = false;
		String str = String.valueOf(n);
		
		for(int i = 1; i < str.length(); i++) {
			for(int j = 0; j <= str.length() - i; j++) {
				int temp = Integer.parseInt(str.substring(j, j + i));	//진부분 문자열
				
				if(temp == 0)
					continue;
				
				if(solution(n-temp) == -1) {
					win = true;
					num = Math.min(num, temp);
				}
			}
		}
		
		//-1:패배 0:모름, 승리:1
		if(win == false)
			return dp[n] = -1;
		
		return dp[n] = num;
	}
	

}

/*
 
 dp[i] : 숫자i(문자열)에 대해서 0은 패배, 그 외는 승리
 예를 들어, i가 일의 자리 수일때는 무조건 지므로 dp[1] ~ dp[9] 는 무조건 0임.
 그리고 i=10일땐,진부분문자열은 1, 0 인데 0은 의미없으므로 빼고 1하나로 두면 1을뺄 때 9인데 
 dp[9]=0이니까 dp[10]=1 이길 수 있음!
 
 */
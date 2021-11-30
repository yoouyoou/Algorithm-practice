package b_LCS;

import java.util.Scanner;

public class b_LCS {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		int[][] dp = new int[B.length()][A.length()];
		
		// 처음 행렬의 왼쪽, 위쪽의 값을 가져오는 값을 지정해주기 위해
		
		for(int i = 0; i < A.length(); i++) {
			for(int j = 0; j < B.length(); j++) {
				if(i == 0 && j > 0) 
					dp[j][i] = dp[j-1][i];
				else if(j == 0 && i > 0)
					dp[j][i] = dp[j][i-1];
				else if(i > 0 && j > 0) {
					dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
					//System.out.println(i +","+j+":"+dp[j][i] + ", " + dp[j-1][i]);
				}
				if(A.charAt(i) == B.charAt(j)) {
					dp[j][i] += 1;
					for(int k = j+1; k < B.length(); k++)
						dp[k][i] = dp[j][i];
					break;
				}
			}
		}
		
		System.out.println(dp[B.length()-1][A.length()-1]);
		sc.close();
		
		/*
		int[][] memo = new int[a.length() + 1][b.length() + 1];
		
		// 0으로 패딩 (a:세로/ b:가로)
		for(int i = 0; i <= a.length(); i++)
			memo[i][0] = 0;
		for(int i = 0; i <= b.length(); i++)
			memo[0][i] = 0;
		
		// 순환식을 따라 메모이제이션을 완성
		for(int i = 1; i <= a.length(); i++) {
			for(int j = 1; j <= b.length(); j++) {
				if(a.charAt(i-1) == b.charAt(j-1))
					memo[i][j] = memo[i-1][j-1] + 1;
				else
					memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
			}
		}
		
		System.out.println(memo[a.length()][b.length()]);
		sc.close();
		return;
		*/
	}

}

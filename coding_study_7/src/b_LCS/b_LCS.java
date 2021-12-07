package b_LCS;

import java.util.Scanner;

public class b_LCS {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		//int[][] dp = new int[B.length()][A.length()];
		//boolean check = false;
		
		// 처음 행렬의 왼쪽, 위쪽의 값을 가져오는 값을 지정해주기 위해
		int[][] dp = new int[A.length() + 1][B.length() + 1];
		
		// 0으로 패딩 (a:세로/ b:가로)
		for(int i = 0; i <= A.length(); i++)
			dp[i][0] = 0;
		for(int i = 0; i <= B.length(); i++)
			dp[0][i] = 0;
		
		// 순환식을 따라 메모이제이션을 완성
		for(int i = 1; i <= A.length(); i++) {
			for(int j = 1; j <= B.length(); j++) {
				if(A.charAt(i-1) == B.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		for(int i = 0; i < A.length()+1; i++) {
			for(int j = 0; j < B.length()+1; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		System.out.println(dp[A.length()][B.length()]);
		sc.close();
		return;
		
		/* 내 코드
		for(int i = 0; i < A.length(); i++) {
			check = false;
			for(int j = 0; j < B.length(); j++) {
				if(i == 0 && j > 0) 
					dp[j][i] = dp[j-1][i];
				else if(j == 0 && i > 0)
					dp[j][i] = dp[j][i-1];
				else if(i > 0 && j > 0) {
					dp[j][i] = dp[j-1][i-1];//dp[j][i] = Math.max(dp[j-1][i], dp[j][i-1]);
					//System.out.println(i +","+j+":"+dp[j][i] + ", " + dp[j-1][i]);
				}
				if(A.charAt(i) == B.charAt(j)) {
					if(!check) {
						dp[j][i] += 1;
						check = true;
					}
				}
			}
		}
		for(int i = 0; i < B.length(); i++) {
			for(int j = 0; j < A.length(); j++)
				System.out.print(dp[i][j] + " ");
			System.out.println();
		}
		
		System.out.println(dp[B.length()-1][A.length()-1]);
		sc.close();
		*/
	}
}

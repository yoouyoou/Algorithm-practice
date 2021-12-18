package b_SNS;

import java.util.ArrayList;
import java.util.Scanner;

//ªÁ»∏∏¡ º≠∫ÒΩ∫ (∞ÒµÂ3)
public class b_2533 {

	static int n;
	static int[][] dp;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		list = new ArrayList[N+1];
		dp = new int[N+1][2];
		
//		for(int i = 1; i <= n; i++)
//			list.add(new ArrayList<Integer>());
		
		for(int i = 0; i < N-1; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			list[u].add(v);
			list[v].add(u);
		}
		
		//dfs(1, -1);
	}
	
	static void dp(int cur, int parent) {
		
	}

}

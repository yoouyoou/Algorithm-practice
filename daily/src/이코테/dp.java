package ภฬฤฺลื;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class dp {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = 7;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++)
			list.add(sc.nextInt());
//		int[] arr = {15, 11, 4, 8, 5, 2, 4};
		
		int[] dp = new int[N];
		Collections.reverse(list);
		Arrays.fill(dp, 1);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++)
				if(list.get(j) < list.get(i))
					dp[i] = Math.max(dp[i], dp[j]+1);
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++)
			ans = Math.max(ans, dp[i]);
		
		System.out.println(N - ans);
	}
	

}

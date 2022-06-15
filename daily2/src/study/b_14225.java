package study;

import java.util.Scanner;

//부분수열의 합
public class b_14225 {

	static int n, ans = 0;
	static int[] s;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		s = new int[n];
		int temp = 0;
		
		for(int i = 0; i < n; i++) {
			s[i] = sc.nextInt();
			temp += s[i];
		}
		
		visited = new boolean[temp + 10];
		comb(0 ,0);

		while(visited[ans])
			ans++;
		
		System.out.println(ans);
		sc.close();
	}
	
	public static void comb(int idx, int sum) {
		if(idx == n) {
			visited[sum] = true;
			return;
		}
		
		comb(idx + 1, sum + s[idx]);
		comb(idx + 1, sum);
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다리 놓기
public class b_1010 {
	
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testcase; i++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			
			visited = new boolean[M];
			solution(N, M);
		}

	}
	
	//mCn
	public static void solution(int n, int m) {
		long ans = 1;
		
		for(int i = 0; i < n; i++) {
			ans *= m - i;
			ans /= i + 1;
		}
		
		System.out.println(ans);
	}

}

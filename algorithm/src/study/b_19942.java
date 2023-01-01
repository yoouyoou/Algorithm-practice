package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다이어트
public class b_19942 {
	
	static int[] selected;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());	//식재료 개수
		int[] limit = new int[4];
		int[][] arr = new int[N][5];
		
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < 4; i++)
			limit[i] = Integer.parseInt(str[i]);
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < 4; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}
		
		for(int i = 1; i <= N; i++) {
			selected = new int[i];
			dfs(0, i, 1);
		}
		
		
	}
	
	public static void dfs(int depth, int num, int start) {
		if(depth == num) {
			//num개 모두 뽑았을 경우
			return;
		}
		
		for(int i = start; i <= N; i++) {
			selected[depth] = i;
			dfs(depth + 1, num, i+1);
			
		}
	}

}

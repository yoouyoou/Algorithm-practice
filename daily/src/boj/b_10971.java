package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���ǿ� ��ȸ2 (�ǹ�2)
public class b_10971 {

	static int min = Integer.MAX_VALUE;
	static int N;
	static int[][] w;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		int[] perm_data = new int[N-1];
		int[] result = new int[N-1];
		boolean[] visited = new boolean[N-1];
		
		for(int i = 0; i < N-1; i++)
			perm_data[i] = i+1;		// 1 ~ N-1 �ֱ� (0�� ���۵��÷� ���� ����)
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				w[i][j] = Integer.parseInt(str[j]);
		}
		
		permutation(0, perm_data, visited, result);
		System.out.println(min);
		br.close();
	}
	
	public static void permutation(int depth, int[] data, boolean[] visited, int[] result) {
		if(depth == N-1) {
			solve(result);
			return;
		}
		
		for(int i = 0; i < N-1; i++) {
			if(!visited[i]) {
				result[depth] = data[i];
				visited[i] = true;
				permutation(depth+1, data, visited, result);
				visited[i] = false;
			}
		}
	}
	
	public static void solve(int[] result) {
		for(int i = 0; i < N-1; i++)
			System.out.print(result[i]+" ");
		System.out.println();
		
		int r = 0;	//���� ����
		int ans = 0;
		
		for(int i = 0; i < N-1; i++) {
			if(w[r][result[i]] == 0)
				return;
			ans += w[r][result[i]];
			r = result[i];
		}
		
		if(w[r][0] == 0)
			return;
		
		ans += w[r][0];
		if(ans < min)
			min = ans;
	}
	

}

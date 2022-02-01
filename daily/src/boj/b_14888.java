package boj;

import java.util.Scanner;

// 연산자 끼워넣기 (실버1)
public class b_14888 {
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int N;
	static int[] An;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int idx = 0;
		N = sc.nextInt();
		An = new int[N];
		int[] perm_data = new int[N-1];
		int[] result = new int[N];
		boolean[] visited = new boolean[N];
		
		for(int i = 0; i < N; i++)
			An[i] = sc.nextInt();
		
		for(int i = 0; i < 4; i++) {
			int operNum = sc.nextInt();
			if(operNum > 0) {
				for(int j = 0; j < operNum; j++)
					perm_data[idx++] = i;
			}
		}
		
		/*for(int i = 0; i < N-1; i++)
			System.out.print(perm_data[i] + " ");*/
		
		
		permutation(N-1, 0, perm_data, result, visited);
		System.out.println(max);
		System.out.println(min);
		sc.close();
	}
	
	public static void permutation(int n, int depth, int[] data, int[] result, boolean[] visited) {
		if(depth == n) {
			confirm(result);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(visited[i] == false) {
				result[depth] = data[i];
				visited[i] = true;
				permutation(n, depth+1, data, result, visited);
				visited[i] = false;
			}
		}
	}
	
	public static void confirm(int[] result) {
//		System.out.println("순열 확인");
//		for(int i = 0; i < N-1; i++)
//			System.out.print(result[i]+" ");
//		System.out.println();
		
		int idx = 0;
		int ans = An[idx++];
		
		for(int i = 0; i < N-1; i++) {
			if(result[i] == 0) 
				ans += An[idx];
			else if(result[i] == 1)
				ans -= An[idx];
			else if(result[i] == 2)
				ans *= An[idx];
			else
				ans /= An[idx];
			idx++;
		}
		
		if(ans < min)
			min = ans;
		if(ans > max)
			max = ans;
		
//		System.out.println("값 확인");
//		System.out.println("ans: " + ans);
//		System.out.println("min: " + min + "max: "+ max);
	}
}

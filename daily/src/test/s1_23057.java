package test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//도전 숫자왕
public class s1_23057 {

	static int ans = 0, sum = 0, N;
	static int[] arr;
	static Set<Integer> set;
//	static boolean[] possible;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		
//		possible = new boolean[sum+1];
		set = new HashSet<>();
		boolean[] visited;
		
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N];
			comb(visited, 0, i);
		}
			
//		for(boolean p : possible)
//			if(p == false)
//				ans++;
		System.out.println(sum - set.size());
		sc.close();
	}
	
	//arr: 뽑을 배열
	public static void comb(boolean[] visited, int start, int r) {
		if(r == 0) {
			int sum2 = 0;
			
			for(int i = 0; i < N; i++) {
				if(visited[i])
					sum2 += arr[i];
			}

			if(sum2 <= sum)
				set.add(sum2);
//				possible[sum2] = true;	//만들 수 있음
		}
		
		for(int i = start; i < N; i++) {
			visited[i] = true;
			comb(visited, i+1, r-1);
			visited[i] = false;
		}
	}

}

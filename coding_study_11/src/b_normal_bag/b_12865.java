package b_normal_bag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//골드5
public class b_12865 {

	static int answer = 0;
	static int K;
	static int[] w;
	static int[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int N = sc.nextInt();
		K = sc.nextInt();
		w = new int[N];				// 무게 배열
		v = new int[N];				// 가중치 배열
		int[] arr = new int[N];		// 뽑을 조합 인덱스 배열
		boolean[] visited = new boolean[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = i;
		
		for(int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i = 1; i < N; i++) {
			combination(arr, visited, 0, N, i);
		}
		
		System.out.println(answer);
		sc.close();
		
	}
	
	public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			// 뽑기 하나 완료
			int weight = 0;
			int value = 0;
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					weight += w[arr[i]];
					value += v[arr[i]];
				}
				if(weight > K)
					return;
			}
			if(value > answer)
				answer = value;
			return;
		}
		
		for(int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}

}

package boj;

import java.util.Scanner;

public class b_2357 {

	static int[] arr;
	static int[] minTree, maxTree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N+1];
		minTree = new int[N * 4];
		maxTree = new int[N * 4];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		// 트리 생성
		minTree(0, N - 1, 1);
		maxTree(0, N - 1, 1);
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(minNum(1, N, 1, a, b) + " " + maxNum(1, N, 1, a, b));
		}
		
		sc.close();
	}
	
	public static int minTree(int start, int end, int node) {
		if(start == end) {
			return minTree[node] = arr[start];
		}
		
		int mid = (start + end) / 2;
		
		return minTree[node] = Math.min(minTree(start, mid, node * 2), minTree(mid + 1, end, node * 2 + 1));
	}
	
	public static int maxTree(int start, int end, int node) {
		if(start == end)
			return maxTree[node] = arr[start];
		int mid = (start + end) / 2;
		return maxTree[node] = Math.max(maxTree(start, mid, node * 2), maxTree(mid + 1, end, node * 2 + 1));
	}
	
	public static int minNum(int start, int end, int node, int left, int right) {
		if(left > end || right < start)
			return Integer.MAX_VALUE;
		
		if(left <= start && end <= right)
			return minTree[node];
		
		int mid = (start + end) / 2;
		return Math.min( minNum(start, mid, node * 2, left, right), minNum(mid + 1, end, node * 2 + 1, left, right) );
	}
	
	public static int maxNum(int start, int end, int node, int left, int right) {
		if(left > end || right < start)
			return Integer.MIN_VALUE;
		
		if(left <= start && end <= right)
			return maxTree[node];
		
		int mid = (start + end) / 2;
		return Math.max( maxNum(start, mid, node * 2, left, right), maxNum(mid + 1, end, node * 2 + 1, left, right) );
	}
}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_9934 {

	static int[] arr;
	static int[] result;
	static int idx = 0;
	static int count = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int N = 1;
		
		for(int i = 0; i < K; i++)
			N *= 2;
		N -= 1;
		
		arr = new int[N];
		result = new int[N];
		String[] str = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(str[i]);
		
		System.out.println(arr[N/2]);
		inorder(0, N-1, 0);
		result[idx++] = arr[N/2];
		
//		int t = 1, a = 0;
//		for(int i = 0; i < N; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		while(a < N) {
//			for(int j = 0; j < t; j++)
//				System.out.print(result[a++] + " ");
//			System.out.println();
//			t *= 2;
//		}
	}
	
	public static int inorder(int s, int e, int cnt) {
		if(s == e)
			return arr[s];
		
		if(cnt % 2 == 0)
			System.out.println();
		
		int m = (s + e) / 2;
//		result[idx++] = inorder(s, m-1);
//		result[idx++] = inorder(m+1, e);
		System.out.print( inorder(s, m - 1, cnt + 1) );
		System.out.print( inorder(m + 1, e, cnt + 1) );
		count *= 2;
		
		return arr[m];
	}

}

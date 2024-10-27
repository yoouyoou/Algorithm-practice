package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2042 {

	static long[] arr, tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int K = Integer.parseInt(str[2]);
		arr = new long[N + 1];
		tree= new long[N * 4];
		
		for(int i = 1; i <= N; i++)
			arr[i] = Long.parseLong(br.readLine());
		
		init(1, N, 1);
		
		for(int i = 1; i <= M + K; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			long c = Long.parseLong(str[2]);
			
			if(a == 1) {
				update(1, N, 1, b, c);
				arr[b] = c;
			}
			else
				System.out.println(sum(1, N, 1, b, (int)c));
		}
	}
	
	public static long init(int start, int end, int node) {
		if(start == end)
			return tree[node] = arr[start];
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
	
	public static long sum(int start, int end, int node, int left, int right) {
		//범위 밖에 있는 경우
		if(left > end || right < start)
			return 0;
		
		//범위 내에 있는 경우
		if(left <= start && end <= right)
			return tree[node];
		
		//그 외 
		int mid = (start + end) / 2;
		return sum(start, mid, node*2, left, right) + sum(mid+1, end, node * 2 + 1, left, right);
	}
	
	public static void update(int start, int end, int node, int index, long val) {
		//바꾸려는 원소가 포함된 배열합이 아닐 경우
		if(index < start || index > end)
			return;
		
		//트리의 1번 노드부터 내려가며 노드 갱신
		tree[node] += val - arr[index];
		int mid = (start + end) / 2;
		
		//리프노드 도달한 경우
		if(start == end)
			return;
		
		update(start, mid, node*2, index, val);
		update(mid+1, end, node*2+1, index, val);
	}
}

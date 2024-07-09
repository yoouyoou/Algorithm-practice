package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class elice_challenge_2 {

	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);	// 배열크기
		int m = Integer.parseInt(str[1]);	// 횟수
		arr = new int[n + 1];
		
		str = br.readLine().split(" ");
		for(int i = 1; i <= str.length; i++)
			arr[i] = Integer.parseInt(str[i-1]);
		
		for(int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int answer = searchK(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
			System.out.println(answer);
		}
				
	}
	
	public static int searchK(int start, int end, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = start; i <= end; i++)
			pq.offer(arr[i]);
		
		for(int i = 0; i < k - 1; i++)
			pq.poll();
		
		return pq.peek();
	}

}

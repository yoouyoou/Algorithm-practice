package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//보석 상자
public class b_2792 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		//PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
		int N = Integer.parseInt(str[0]);	//학생수
		int M = Integer.parseInt(str[1]);	//보석종류
		int[] jewelry = new int[M];
		
		int left = 1, right = Integer.MIN_VALUE;	//질투심이 될 수 있는 숫자 범위
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {
			jewelry[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, jewelry[i]);
		}
		
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			
			int n = 0;
			//해당 질투심 mid로 보석 나누기가 가능한지 확인
			for(int i = 0; i < M; i++) {
				int people = jewelry[i] % mid == 0 ? jewelry[i] / mid : jewelry[i] / mid + 1;
//				n += (jewelry[i] / mid) + (jewelry[i] % mid);
				n += people;
			}
			
			if(N >= n) {	//해당 인원 내로 보석을 나눌 수 있음
				right = mid - 1;
				ans = Math.min(ans, mid);
			}
			else {
				left = mid + 1;
			}
		
		}
		
		System.out.println(ans);
	}

}

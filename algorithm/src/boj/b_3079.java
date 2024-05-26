package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_3079 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		long start, end;
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[] arr = new int[N];
		
		Arrays.sort(arr);	//심사를 받는데 걸리는 최소값이므로 빨리 끝나는 심사대부터 해야 함
		
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			arr[i] = t;
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		start = M / N * min;
		end = max * M;
		
		while(start <= end) {
			long mid = (start + end) / 2;	//현재 추정 걸리는 시간
			long cnt = 0;
			
			// min시간으로 입국 심사를 처리할 수 있는지 계산
			for(int i = 0; i < N; i++) {
				cnt += mid / arr[i];
				
				// 해당 시간 안에 처리할 수 있는 인원수를 마냥 더해버리면 cnt는 M보다 항상 커지겟지.. 그래서 Arrays배열 순으로 더해주다가 이미 인원이 다 찼으면 나가버려야 함
				if(cnt >= M)
					break;
			}
			
			if(cnt < M)	//가능하다면 올려!
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		System.out.println(start);
	}

}

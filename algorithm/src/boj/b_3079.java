package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_3079 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[] arr = new int[N];
		int max = 0, time = 1, count = 0;
		
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			arr[i] = t;
			max = Math.max(max, arr[i]);
		}
		
		max *= M;
		System.out.println("max time: " + max);
		
		while(time <= max) {
			System.out.println("\n현재 time: " + time);
			
			for(int i = 0; i < arr.length; i++) {
				if(time % arr[i] == 0) {
					System.out.println(arr[i] + "심사대 통과");
					count++;
				}
			}
			System.out.println("count: " + count);
			if(count >= M)
				break;
			time++;
		}
		
		System.out.println("\ntime: " + time);
	}

}

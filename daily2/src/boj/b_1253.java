package boj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//¡¡¥Ÿ
public class b_1253 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int N = sc.nextInt();
		int answer = 0;
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i]) + 1);
			else
				map.put(arr[i], 1);
		}

		Arrays.sort(arr);
		
		for(int i = 2; i < N; i++) {
			int sidx = 0, eidx = i-1;
			
			if(map.get(arr[i]) > 1)
				eidx = i;
			
			while(sidx < eidx) {
				if(arr[i] == arr[sidx] + arr[eidx]) {
					answer++;
					break;
				}
				else if(arr[i] > arr[sidx] + arr[eidx])
					sidx++;
				else
					eidx--;

			}
			
		}
		
//		if(map.containsKey(0) && map.get(0) >= 3) 
//			answer += 2;
		if(arr[0] == 0 && arr[1] != 0 && map.get(arr[1]) > 1)
			answer += 1;
		else if(arr[0] == 0 && arr[1] == 0 && map.get(0) >= 3)
			answer += 2;
		
		System.out.println(answer);
		sc.close();
	}

}

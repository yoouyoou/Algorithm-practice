package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

//신입 사원
public class b_1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testcase; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];	//1차 저장
			HashMap<Integer, Integer> map = new HashMap<>(); //<1차,2차>
			
			for(int j = 0; j < n; j++) {
				String[] str = br.readLine().split(" ");
				arr[j] = Integer.parseInt(str[0]);
				map.put(arr[j], Integer.parseInt(str[1]));
			}
			
			System.out.println(solution(arr, map));
		}
	}
	
	public static int solution(int[] arr, HashMap<Integer, Integer> map) {
		int sum = 1;
		
		Arrays.sort(arr);
		int stand = map.get(arr[0]);
		
		for(int i = 1; i < arr.length; i++) {
			if(stand >= map.get(arr[i])) {
				stand = map.get(arr[i]);
				sum++;
			}
		}
		return sum;
	}

}

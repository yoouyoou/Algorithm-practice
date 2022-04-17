package 이코테;

import java.util.Arrays;
import java.util.Collections;

public class binarySearch {

	public static void main(String[] args) {
		int N = 4;	//떡 개수
		int M = 6;	//최소 떡의 양
		Integer[] arr = {19, 15, 10, 17};
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i = arr[0]-1; i >= 0; i--) {
			int mine = 0;
			for(int j = 0; j < arr.length; j++)
				if(arr[j] > i)
					mine += arr[j] - i;
			if(mine >= M) {
				System.out.println(i);
				break;
			}
		}

	}

}

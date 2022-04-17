package ภฬฤฺลื;

import java.util.Arrays;
import java.util.Collections;

public class sorting {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		int[] a = {1, 2, 5, 4, 3};
		Integer[] b = {5, 5, 6, 6, 5};
		
		Arrays.sort(a);
		Arrays.sort(b, Collections.reverseOrder());
		
		int sum = 0;
		for(int i = 0; i < k; i++) {
			if(a[i] < b[i])
				a[i] = b[i];
		}
		
		for(int i = 0; i < n; i++)
			sum += a[i];
		System.out.println(sum);
	}

}

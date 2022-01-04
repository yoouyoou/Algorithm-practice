package b_ATM;

import java.util.Arrays;
import java.util.Scanner;

//½Ç¹ö3
public class b_11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n];
		int sum = 0;
		
		for(int i = 0; i < n; i++) 
			time[i] = sc.nextInt();
		
		Arrays.sort(time);
		
		for(int i = 0; i < n; i++)
			for(int j = 0; j <= i; j++)
				sum += time[j];
		
		System.out.println(sum);
		sc.close();
	}
}


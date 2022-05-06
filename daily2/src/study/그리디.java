package study;

import java.util.Arrays;
import java.util.Scanner;

//수 묶기
public class 그리디 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int ans = 0;
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		//-1 2 1 3
		int i = N - 1;
		Arrays.sort(arr);
		for(i = N-1; i > 0; i--) {
			
			if(arr[i] <= 0)
				break;
			
			if(arr[i] > 1 && arr[i-1] > 1) {		//둘다 양수
				ans += arr[i] * arr[i-1];
				i--;
			}
			else
				ans += arr[i];
		}
		
		if(i == 0)
			ans += arr[0];
		else {
			for(int j = 0; j <= i; j++) {
				if(j == i) {
					ans += arr[j];
					break;
				}
				ans += arr[j] * arr[j+1];
				j++;
			}
		}
		
//		if(arr[0] < 0 && arr[1] < 0) {
//			for(int i = 2; i < N; i++)
//				ans += arr[i];
//			ans += arr[0] * arr[1];
//		}
//		else {
//			for(int i = 0; i < N-2; i++)
//				ans += arr[i];
//			ans += arr[N-1] * arr[N-2];
//		}
		
		System.out.println(ans);
		sc.close();
	}

}

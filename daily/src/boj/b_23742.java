package boj;

import java.util.Arrays;
import java.util.Scanner;

public class b_23742 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		int num = 0;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] > 0)
				num++;
		}
		
		int ans = 0;
		
		//만약 모두 양수일 경우
		if(num == N) {
			Arrays.sort(arr);
			for(int i = 0; i < N-1; i++)
				ans += num * arr[i];
//			ans += arr[N-1];
		}
		//음수가 하나라도 있으면
		else {
			for(int a: arr) {
				if(a < 0)		//음수면 혼자 팀하게 냅둠
					ans += a;
				else
					ans += num * a;
			}	
		}
		
		System.out.println(ans);
	}

}

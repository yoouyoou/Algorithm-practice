package boj;

import java.util.Scanner;

//K번째 수
public class b_1300 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		int ans = 0;
		int low, high, mid;
		
		low = 1;
		high = k;
		
		while(low <= high) {
			mid = (low + high) / 2;		//임의의 수 지정 
			
			int pos = 0;				//mid의 위치 구하기(몇번째에 있는지)
			for(int i = 1; i <= N; i++)
				pos += Math.min(N, mid/i);	
			
			if(pos >= k) {
				high = mid - 1;
				ans = mid;
			}
			else 
				low = mid + 1;	//왜 여기에 같음 처리를 해주면 안되는지????
		}

		System.out.println(ans);
		sc.close();
	}

}

package boj;

import java.util.Scanner;

//벼락치기
public class b_23739 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();	//과목별 시간 저장 배열
		
		int time = 30;				
		int idx = 0;				//과목 인덱스
		int ans = 0;				//과목 반 이상 공부한거 저장할 변수
		while(true) {
			
			if(idx == N)
				break;
			
			if(Math.ceil(arr[idx] / 2.0) <= time) {	
				ans++;								
			}
			
			time -= arr[idx++];						
													
			
			if(time <= 0) {							
				time = 30;
				continue;
			}
		
		}
		
		System.out.println(ans);
	}
}

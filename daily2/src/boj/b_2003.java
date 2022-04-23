package boj;

import java.util.Scanner;

public class b_2003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int answer = 0;
		int sidx = 0, eidx = 0;
		int sum = arr[0];
		while(true) {
			System.out.println("[" + sidx +", " + eidx + "] = " + sum);
			
			if(eidx >= N)
				break;
			
			if(sum == M) {			//M과 같아졌을 때
				answer++;
				sum -= arr[sidx];
				if(sum == 0) {			//sidx == eidx
					sum += arr[sidx+1];	//sum값 초기화
					eidx++;				//eidx도 같이 올려주기
				}
				sidx++;
			}
			else if(sum < M) {			//합이 M보다 더 작을 때
				eidx++;					//eidx를 올려줌
				if(eidx == N)
					break;
				sum += arr[eidx];
			}
			else {						//합이 M보다 클 때
				sum -= arr[sidx];
				sidx++;
			}
		}

		System.out.println(answer);
		sc.close();
	}

}

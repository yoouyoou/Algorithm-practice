package b_yosephus;

import java.util.Scanner;

public class b_11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		permutation(N, K);
		sc.close();
	}
	
	public static void print(int[] arr, int N) {
		System.out.print("<");
		for(int i = 0; i < N; i++) {
			if(i == N-1)
				System.out.println(arr[i] + ">");
			else
				System.out.print(arr[i] + ", ");
		}
	}
	
	public static void permutation(int N, int K) {
		int[] person = new int[N];
		int[] result = new int[N];
		int check = 0;				// k번째인지 확인하는 변수
		int idx = 0, rIdx = 0;
		
		for(int i = 0; i < N; i++)	// 1~N값 넣기
			person[i] = i+1;
		
		// 계속 검사
		while(rIdx != N) {
			if(idx == N)
				idx = 0;
			
			if(person[idx] != -1) 
				check++;
			
			if(check == K) {
				check = 0;
				result[rIdx++] = person[idx];
				person[idx] = -1;
			}
			
			idx++;
		}
		
		//print(person, N);
		print(result, N);
	}

}

package swea;

import java.util.Scanner;

//두 개의 숫자열
public class s_1959 {

	static int tc = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int i = 0; i < testcase; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] A = new int[N];
			int[] B = new int[M];
			
			for(int n = 0; n < N; n++)
				A[n] = sc.nextInt();
			
			for(int m = 0; m < M; m++)
				B[m] = sc.nextInt();
			
			solution(A, B);
		}
		
		sc.close();
	}
	
	public static void solution(int[] A, int[] B) {
		System.out.println(tc + "번째");
		int maxLen, minLen, ans = 0;
		boolean Aflag = false;
		
		if(A.length >= B.length) {
			maxLen = A.length;
			minLen = B.length;
			Aflag = true;
		}
		else {
			maxLen = B.length;
			minLen = A.length;
		}
		
		for(int i = 0; i <= maxLen - minLen; i++) {
			int sum = 0, idx = i;
			
			for(int j = 0; j < minLen; j++) {
				if(Aflag) {
					System.out.println(A[idx] + "*" + B[j]);
					sum += A[idx++] * B[j];
				}else {
					System.out.println(B[idx] + "*" + A[j]);
					sum += B[idx++] * A[j];
				}
			}
			
			System.out.println("sum: " + sum);
			ans = Math.max(ans, sum);
		}
		
		System.out.println("#" + tc++ + " " + ans);
	}

}

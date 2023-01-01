package test;
import java.util.*;

//비즈마켓
public class s2_25045 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long answer = 0;
		int N = sc.nextInt();	//상품수
		int M = sc.nextInt();	//기업수
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[M];
		
		for(int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		for(int i = 0; i < M; i++)
			B[i] = sc.nextInt();
			
		Arrays.sort(A, Collections.reverseOrder());	//내림차순
		Arrays.sort(B);	//오름차순
		
		int temp = A.length > B.length ? B.length : A.length;
		for(int i = 0; i < temp; i++) {
			if(A[i] - B[i] > 0)
				answer += A[i] - B[i];
		}
		
		System.out.println(answer);
		sc.close();
	}

}


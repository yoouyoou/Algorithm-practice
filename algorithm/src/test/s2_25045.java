package test;
import java.util.*;

//�����
public class s2_25045 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long answer = 0;
		int N = sc.nextInt();	//��ǰ��
		int M = sc.nextInt();	//�����
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[M];
		
		for(int i = 0; i < N; i++)
			A[i] = sc.nextInt();
		
		for(int i = 0; i < M; i++)
			B[i] = sc.nextInt();
			
		Arrays.sort(A, Collections.reverseOrder());	//��������
		Arrays.sort(B);	//��������
		
		int temp = A.length > B.length ? B.length : A.length;
		for(int i = 0; i < temp; i++) {
			if(A[i] - B[i] > 0)
				answer += A[i] - B[i];
		}
		
		System.out.println(answer);
		sc.close();
	}

}


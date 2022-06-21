package boj;

import java.util.Arrays;
import java.util.Scanner;

//���� �ڸ���
public class b_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 0;
		int N = sc.nextInt();	//���� ����
		int M = sc.nextInt();	//���������� �ϴ� ����
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr[N-1];
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;	//���ܱ� �� ����
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] > mid)
					sum += arr[i] - mid;
			}
			
			if(sum >= M) {
				start = mid + 1;
				answer = mid;
			}
			else
				end = mid - 1;
		}
		
		System.out.println(answer);
		sc.close();
	}

}

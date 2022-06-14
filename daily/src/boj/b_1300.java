package boj;

import java.util.Scanner;

//K��° ��
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
			mid = (low + high) / 2;		//������ �� ���� 
			
			int pos = 0;				//mid�� ��ġ ���ϱ�(���°�� �ִ���)
			for(int i = 1; i <= N; i++)
				pos += Math.min(N, mid/i);	
			
			if(pos >= k) {
				high = mid - 1;
				ans = mid;
			}
			else 
				low = mid + 1;	//�� ���⿡ ���� ó���� ���ָ� �ȵǴ���????
		}

		System.out.println(ans);
		sc.close();
	}

}

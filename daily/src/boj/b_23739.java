package boj;

import java.util.Scanner;

//����ġ��
public class b_23739 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();	//���� �ð� ���� �迭
		
		int time = 30;				
		int idx = 0;				//���� �ε���
		int ans = 0;				//���� �� �̻� �����Ѱ� ������ ����
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

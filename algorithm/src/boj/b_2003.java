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
			
			if(sum == M) {			//M�� �������� ��
				answer++;
				sum -= arr[sidx];
				if(sum == 0) {			//sidx == eidx
					sum += arr[sidx+1];	//sum�� �ʱ�ȭ
					eidx++;				//eidx�� ���� �÷��ֱ�
				}
				sidx++;
			}
			else if(sum < M) {			//���� M���� �� ���� ��
				eidx++;					//eidx�� �÷���
				if(eidx == N)
					break;
				sum += arr[eidx];
			}
			else {						//���� M���� Ŭ ��
				sum -= arr[sidx];
				sidx++;
			}
		}

		System.out.println(answer);
		sc.close();
	}

}

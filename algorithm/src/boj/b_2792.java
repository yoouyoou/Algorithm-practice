package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� ����
public class b_2792 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		//PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
		int N = Integer.parseInt(str[0]);	//�л���
		int M = Integer.parseInt(str[1]);	//��������
		int[] jewelry = new int[M];
		
		int left = 1, right = Integer.MIN_VALUE;	//�������� �� �� �ִ� ���� ����
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < M; i++) {
			jewelry[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, jewelry[i]);
		}
		
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			
			int n = 0;
			//�ش� ������ mid�� ���� �����Ⱑ �������� Ȯ��
			for(int i = 0; i < M; i++) {
				int people = jewelry[i] % mid == 0 ? jewelry[i] / mid : jewelry[i] / mid + 1;
//				n += (jewelry[i] / mid) + (jewelry[i] % mid);
				n += people;
			}
			
			if(N >= n) {	//�ش� �ο� ���� ������ ���� �� ����
				right = mid - 1;
				ans = Math.min(ans, mid);
			}
			else {
				left = mid + 1;
			}
		
		}
		
		System.out.println(ans);
	}

}

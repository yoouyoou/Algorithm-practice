package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b_3079 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		long min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		long start, end;
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[] arr = new int[N];
		
		Arrays.sort(arr);	//�ɻ縦 �޴µ� �ɸ��� �ּҰ��̹Ƿ� ���� ������ �ɻ����� �ؾ� ��
		
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(br.readLine());
			arr[i] = t;
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		
		start = M / N * min;
		end = max * M;
		
		while(start <= end) {
			long mid = (start + end) / 2;	//���� ���� �ɸ��� �ð�
			long cnt = 0;
			
			// min�ð����� �Ա� �ɻ縦 ó���� �� �ִ��� ���
			for(int i = 0; i < N; i++) {
				cnt += mid / arr[i];
				
				// �ش� �ð� �ȿ� ó���� �� �ִ� �ο����� ���� ���ع����� cnt�� M���� �׻� Ŀ������.. �׷��� Arrays�迭 ������ �����ִٰ� �̹� �ο��� �� á���� ���������� ��
				if(cnt >= M)
					break;
			}
			
			if(cnt < M)	//�����ϴٸ� �÷�!
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		System.out.println(start);
	}

}

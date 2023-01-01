package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//������ ��ġ
public class b_2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int answer = 0;
		int N = Integer.parseInt(str[0]);	//�� ����
		int C = Integer.parseInt(str[1]);	//������ ����
		int[] arr = new int[N];				//���� x��ǥ
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[N-1] - arr[0];
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			int count = 1; 	//������ ��ġ ����
			int cur = arr[0];	//���� ù��° �� ��ġ
			
			//�ش� mid���� ���� ������ �������� ���� �Ǵ��� Ȯ�� -> ������ �� �Ÿ����� mid�� �ּҰ� �Ǿ��
			for(int i = 1; i < N; i++) {
				if(arr[i] - cur >= mid) {
					count++;
					cur = arr[i];
				}
			}
			
			if(count >= C) { //��ġ�� �� �����Ƿ� ������ �Ÿ��� �� ������
				start = mid + 1;
				answer = mid;
			}
			else	//mid���� ���̰� �ǵ��� ������ ��ġ�� ���ϹǷ� �Ÿ��� �ٿ��� ��
				end = mid - 1;
		}
		
		System.out.println(answer);
	}

}

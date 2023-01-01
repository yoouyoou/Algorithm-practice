package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//ȸ���ϴ� ť
public class b_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);	//���� ����
		int M = Integer.parseInt(str[1]);	//����
		str = br.readLine().split(" ");
		
		int[] m = new int[M];
		for(int i = 0; i < M; i++) 
			m[i] = Integer.parseInt(str[i]);
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= N; i++)
			list.add(i);
		
		for(int i = 0; i < M; i++) {
			int curIdx = list.indexOf(m[i]);	//��ü�� ����� �ε����� ��ȯ
			//curIdx:���� ����, list.size()-curIdx:�������� ������ ����
			if(curIdx < list.size() - curIdx) {		//���� ������ �� ������ (���̵�)
				while(m[i] != list.getFirst()) 	//ù��° ��� ��ȯ
					list.add(list.poll());
				answer += curIdx;
			}
			else {
				while(m[i] != list.peekLast())
					list.addFirst(list.pollLast());
				list.addFirst(list.pollLast());
				answer += list.size() - curIdx;
			}
			
			list.remove();	//ù��° ��� ����
		}

		System.out.println(answer);
	}

}

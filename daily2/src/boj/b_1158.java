package boj;

import java.util.ArrayList;
import java.util.Scanner;

//�似Ǫ�� ����
public class b_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//�ο�
		int K = sc.nextInt();	//���� ����
		int[] answer = new int[N];
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++)
			list.add(i);
		
		int cnt = 0, idx = 0, temp = 0;
		while(!list.isEmpty()) {
			
			cnt++;
			/*Ȯ�� ���
			System.out.print(cnt + "��°: ");
			for(int k: list)
				System.out.print(k + " ");
			System.out.println();
			System.out.println("---------------------------");
			Ȯ�� ��*/
			
			if(cnt == K) {
				//System.out.println("����! idx: " + idx);
				answer[temp++] = list.get(idx);
				list.remove(idx);
				cnt = 0;
				if(idx > list.size()-1)	//idx�� list�� �������� ���� ��� ó��
					idx = 0;
				continue;
			}
			idx++;
			if(idx > list.size()-1)
				idx = 0;
		}

		System.out.print("<");
		for(int i = 0; i < N; i++)
			if(i == N-1)
				System.out.print(answer[i] + ">");
			else
				System.out.print(answer[i] + ", ");
		
		sc.close();
	}

}

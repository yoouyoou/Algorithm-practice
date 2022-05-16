package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�� �����
public class b_2252 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] indegree = new int[N+1];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);	//
			indegree[b]++;	//�������� ����
		}
		
		for(int i = 1; i <= N; i++)
			if(indegree[i] == 0)	//�켱����
				q.offer(i);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");	//�������� ���� �� ������
			
			//�ش� ���Ҹ� ó�������ν� �� �� �ִ� ���� ���ؼ� ť�� �ֱ�
			for(int i = 0; i < list[now].size(); i++) {
				indegree[list[now].get(i)]--;		//�ٸ� ������ �������� ���� �ϳ� ������
				
				if(indegree[list[now].get(i)] == 0)	//���� ���������� 0�̸�
					q.offer(list[now].get(i));		// �ٽ� �ֱ�
			}
		}
		
		sc.close();
	}

}

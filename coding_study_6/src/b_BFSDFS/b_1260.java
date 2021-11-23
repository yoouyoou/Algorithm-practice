package b_BFSDFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_1260 {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// ���� ����
		int M = sc.nextInt();	// ���� ����
		int V = sc.nextInt();	// ���� ����
		
		list = new ArrayList[N+1];	// ArrayList�迭 �ʱ�ȭ. ������ ��ȣ��� �ε����� ���߱� ���� N+1 ũ��� ����
		
		for(int i = 1; i < N+1; i++)//
			list[i] = new ArrayList<Integer>();//
		
		for(int i = 0; i < M; i++) {//
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		//���� �������� �������� �湮�ϹǷ� ���� �ʿ�
		for(int i = 1; i < N+1; i++)
			Collections.sort(list[i]);	// ArrayList���� �޼ҵ�
		
		visited = new boolean[N+1]; // ���� �湮���θ� ���� ���� ������ �°� �迭 ���� : boolean�� �ʱ� �������� false
		DFS(V);						// ���� �������� ���̿켱Ž�� ����
		System.out.println();
		
		visited = new boolean[N+1]; // �湮�迭 �ٽ� �ʱ�ȭ
		BFS(V);						// ���� �������� �ʺ�켱 Ž�� ����
		
		sc.close();
	}
	
	static void DFS(int x) {
		if(visited[x])	
			return;		// �̹� �湮�� ���̶�� �ٷ� ����
		
		visited[x] = true;	// �ƴϸ� �湮�ߴٰ� ǥ��
		System.out.print(x + " ");
		
		for(int y : list[x])	// �湮 ������ �̾��� �ٸ� ������ �ϳ��ϳ� Ȯ��
			if(!visited[y])		// ���� �湮�� �ȵǾ��ٸ�
				DFS(y);			// ��� ���� �̾��
	}
	
	static void BFS(int x) {
		Queue<Integer> q = new LinkedList<Integer>();	// ť����
		q.add(x);	// ���� ť�� �ֱ�
		visited[x] = true;	// ���� �湮�ߴٰ� ǥ��
		
		int n;
		while(!q.isEmpty()) {	// ť �� ������ �ݺ�
			n = q.poll();		// ť�� ù��° �� ������
			System.out.print(n + " ");	
			
			for(int y : list[n]) {	// ù��° �湮 ������ ������ ������ Ȯ��
				if(!visited[y]) {	// �湮���� �ʾҴٸ�
					q.add(y);		// ť�� �ְ�
					visited[y] = true; // �湮ǥ��
				}
			}
			// ù��° ������ ������ �ֵ� �� ť�� �ְ�, �ٽ� ���� �ö� �� ���� ���ٽ� ť���� �����鼭 ������ ���� ������ �ֵ� ť�� �ֱ�..
		}
		
	}

}

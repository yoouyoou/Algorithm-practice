package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//���� ���� ���Գ�
public class s1_23059 {

	static HashMap<String, Integer> map;
	static String[] sortingKey;
	static int[] indegree;
	static int idx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] a = new String[N];
		String[] b = new String[N];
		map = new HashMap<>();	//�������̸�, �ε���
		indegree = new int[200001];
		
		idx = 0;
		for(int i = 0; i < N; i++) {
			String A = sc.next();
			String B = sc.next();

			if(!map.containsKey(A))
				map.put(A, idx++);
			if(!map.containsKey(B))
				map.put(B, idx++);
			
			indegree[map.get(B)]++;	//�������� ����
			a[i] = A;
			b[i] = B;
		}
		
		sortingKey = new String[idx-1];
		idx = 0;
		for(String s: map.keySet())
			sortingKey[idx++] = s;
		
		Arrays.sort(sortingKey);	//������ �̸� ������ ����
	}
	
	//Map<������ �̸�, �ε���>
	public static void topoplgySort() {
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		//���������� 0�� ������ �߿��� �������� ���� ���� �ַ� ���
		idx = 0;
		for(int i = 0; i < idx; i++)
			if(indegree[i] == 0)
//				sortingKey[idx++] = map.get
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
		}
	}
	
}

class Item implements Comparable<Item>{
	int idx;
	String item;
	
	public Item(int idx, String item) {
		this.idx = idx;
		this.item = item;
	}

	@Override
	public int compareTo(Item arg0) {
		if(this.item.compareTo(arg0.item) > 0)
			return 1;
		return 0;
	}
}

/*

1. ���� ������ �� �ִ� ������ �� ���� �������� ���� �������� ��� ã��
2. ã�� �������� ���� ������ ����

*/

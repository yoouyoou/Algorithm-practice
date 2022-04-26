package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//리그 오브 레게노
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
		map = new HashMap<>();	//아이템이름, 인덱스
		indegree = new int[200001];
		
		idx = 0;
		for(int i = 0; i < N; i++) {
			String A = sc.next();
			String B = sc.next();

			if(!map.containsKey(A))
				map.put(A, idx++);
			if(!map.containsKey(B))
				map.put(B, idx++);
			
			indegree[map.get(B)]++;	//진입차수 개수
			a[i] = A;
			b[i] = B;
		}
		
		sortingKey = new String[idx-1];
		idx = 0;
		for(String s: map.keySet())
			sortingKey[idx++] = s;
		
		Arrays.sort(sortingKey);	//아이템 이름 사전순 정렬
	}
	
	//Map<아이템 이름, 인덱스>
	public static void topoplgySort() {
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		//진입차수가 0인 아이템 중에서 사전순이 가장 빠른 애로 골라
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

1. 현재 구매할 수 있는 아이템 중 아직 구매하지 않은 아이템을 모두 찾아
2. 찾으 아이템을 사전 순으로 구매

*/

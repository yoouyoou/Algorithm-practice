package boj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//模备 匙飘况农
public class b_4195 {

	static int[] parent;
	static int[] count;
	static HashMap<String, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i = 0; i < testcase; i++) {
			int F = sc.nextInt();	//模备 包拌 荐
			int idx = 1;
			parent = new int[200001];
			count = new int[200001];
			map = new HashMap<>();
			
			Arrays.fill(count, 1);
			for(int a = 1; a <= 200000; a++)
				parent[a] = a;
			
			for(int j = 0; j < F; j++) {
				String s1 = sc.next();
				String s2 = sc.next();
				
				if(!map.containsKey(s1))
					map.put(s1, idx++);
				
				if(!map.containsKey(s2))
					map.put(s2, idx++);
				
				solution(s1, s2);
			}
		}
		
		sc.close();
	}
	
	public static void solution(String s1, String s2) {

//		if(find(t1) == find(t2)) {	//悼老茄 模备 包拌啊 唱吭阑 版快
//			System.out.println( count[find(map.get(s1))] );
//			return;
//		}
		
		union(map.get(s1), map.get(s2));
		System.out.println( count[find(map.get(s1))] );
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y)	return;
		else if(x < y) {
			parent[y] = x;
			count[x] += count[y];
		}
        else {
        	parent[x] = y;
        	count[y] += count[x];
        }
	}
	
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		
		return parent[x] = find(parent[x]);	
	}
	

}

package boj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//模备 匙飘况农
public class b_4195 {

	static int[] parent;
	static HashMap<String, Integer> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i = 0; i < testcase; i++) {
			int F = sc.nextInt();	//模备 包拌 荐
			int idx = 1;
			parent = new int[100000];
			map = new HashMap<>();
			
			for(int a = 1; a < 100000; a++)
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
		int sum = 0, temp;
		union(map.get(s1), map.get(s2));
		temp = find(map.get(s1));
		
		for(int i = 1; i < parent.length; i++)
			if(parent[i] == temp)
				sum++;

		System.out.println(sum);
	}
	
	public static int find(int x) {
		if(parent[x] == x)
			return x;
		
		return parent[x] = find(parent[x]);	
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y)
			parent[y] = x;
	}
	

}

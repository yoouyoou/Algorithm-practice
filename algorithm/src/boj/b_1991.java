package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class b_1991 {
	
	static HashMap<Character, Integer> map;
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new HashMap<>();
		arr = new char[N][2];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str.charAt(0), i);
			arr[i][0] = str.charAt(2);
			arr[i][1] = str.charAt(4);
		}
		
		preOrder('A');
		System.out.println();
		
		inOrder('A');
		System.out.println();
		
		postOrder('A');
		System.out.println();
	}
	
	public static void preOrder(char ch) {
		if(ch == '.') 
			return;
		
		System.out.print(ch);
		preOrder(arr[map.get(ch)][0]);
		preOrder(arr[map.get(ch)][1]);
	}
	
	public static void inOrder(char ch) {
		if(ch == '.')
			return;
		
		inOrder(arr[map.get(ch)][0]);
		System.out.print(ch);
		inOrder(arr[map.get(ch)][1]);
	}
	
	public static void postOrder(char ch) {
		if(ch == '.')
			return;
		
		postOrder(arr[map.get(ch)][0]);
		postOrder(arr[map.get(ch)][1]);
		System.out.print(ch);
	}

}

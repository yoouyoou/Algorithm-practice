package study;

import java.util.Scanner;

public class elice_challenge {

	static int Ncount, num, min = Integer.MAX_VALUE;
	static int[] arr, list;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		num = Integer.parseInt(N);
		Ncount = N.length();
		arr = new int[N.length()];
		list = new int[N.length()];
		visited = new boolean[N.length()];
	
		for(int i = 0; i < N.length(); i++) {
			arr[i] = N.charAt(i) - '0';
		}
		
		Solution(0);
		System.out.println(min);
		sc.close();
	}
	
	public static void Solution(int depth) {
		if(depth == Ncount) {
			String str = "";
			for(int i: list)
				str += i;
			
			int n = Integer.parseInt(str);
			if(num < n)
				min = Math.min(min, n);
			return;
		}
		
		for(int i = 0; i < Ncount; i++) {
			if(!visited[i]) {
				visited[i] = true;
				list[depth] = arr[i];
				Solution(depth + 1);
				visited[i] = false;
			}
		}
	}

}

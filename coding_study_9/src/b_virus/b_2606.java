package b_virus;

import java.util.ArrayList;
import java.util.Scanner;

//바이러스 (실버3)
public class b_2606 {
	
	static boolean visited[];
	static ArrayList<Integer> list[];
	static int total = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int com = sc.nextInt();
		int num = sc.nextInt();
		visited = new boolean[com + 1];
		list = new ArrayList[com + 1];
		
		for(int i = 1; i <= com; i++)
			list[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < num; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i = 1; i <= com; i++) 
			DFS(1);
		
		System.out.println(total-1);
	}
	
	public static void DFS(int x) {
		if(visited[x])
			return;
		
		visited[x] = true;
		total++;
		
		for(int n : list[x]) {
			if(!visited[n])
				DFS(n);
		}
	}

}

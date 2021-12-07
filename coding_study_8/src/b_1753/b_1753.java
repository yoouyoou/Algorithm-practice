package b_1753;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//최단경로 (골드5)
public class b_1753 {

	static int[] weight;
	static ArrayList<String>[] list;
	static boolean check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		int startV = sc.nextInt();
		
		weight = new int[V+1];
		list = new ArrayList[V+1];
		for(int i = 1; i < V+1; i++)
			list[i] = new ArrayList<String>();
		
		for(int i = 0; i < E; i++) {
			//HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			//map.put(v, w);
			String temp = String.valueOf(v) + "," + String.valueOf(w);
			list[u].add(temp);
			//list[u].add(map);
		}
		
		//정점이 정렬되어져서 들어간 게 아님 
		
		for(int i = 1; i <= V; i++) {
			if(i != startV) {
				DFS(startV, i, 0);
				if(check == false)
					weight[i] = -1;
			}
		}
		
		for(int i = 1; i <= V; i++) {
			if(weight[i] == -1)
				System.out.println("INF");
			else
				System.out.println(weight[i]);
		}
		
		sc.close();
		return;
	}
	
	static void DFS(int start, int destination, int total) {
		if(start == destination) {
			if(weight[destination] == 0 || total < weight[destination])
				weight[destination] = total;
			check = true;
			return;
		}
		
		for(String str : list[start]) {
			String[] s = str.split(",");
			int v = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);
			/*if(v == destination) {
				total = w;
				check = true;
				return;
			}*/
			total += w;
			check = false;
			DFS(v, destination, total);
		}
	}

	/*
	static void DFS(int start, int destination) {
		if(start == destination) {
			check = true;
			return;
		}
		
		for(String str : list[start]) {
			String[] s = str.split(",");
			int v = Integer.parseInt(s[0]);
			int w = Integer.parseInt(s[1]);
			if(v == destination) {
				weight[destination] = w;
				check = true;
				return;
			}
			weight[destination] += w;
			check = false;
			DFS(v, destination);
		}
	}
	*/

}

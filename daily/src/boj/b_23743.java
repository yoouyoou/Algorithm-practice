package boj;

import java.util.ArrayList;
import java.util.Scanner;

//πÊ≈ª√‚
public class b_23743 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		ArrayList<Nodee>[] list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++)
			list[i] = new ArrayList<Nodee>();
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			list[a].add(new Nodee(b, c));
			list[b].add(new Nodee(a, c));
		}
		
		int[] exit = new int[N+1];
		for(int i = 1; i <= N; i++)
			exit[i] = sc.nextInt();
	}

}

class Nodee{
	int idx, cost;
	
	public Nodee(int idx, int cost) {
		this.idx = idx;
		this.cost = cost;
	}
}


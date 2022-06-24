package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//¼û¹Ù²ÀÁú
public class b_1697 {

	static int ans = 0, K;
	static int[] visited = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		
//		bfs(N, 0);
		
        if(N == K)
            ans = 0;
        else
		    bfs2(N);
        
		System.out.println(ans);
		sc.close();
	}

	public static void bfs2(int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, 0});
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			System.out.println(temp[0] + " "  + temp[1]);
			
			if(temp[0] == K) {
				ans = temp[1];
				return;
			}
			
			q.add(new int[] {temp[0] + 1, temp[1] + 1});
			q.add(new int[] {temp[0] - 1, temp[1] + 1});
			q.add(new int[] {temp[0] * 2, temp[1] + 1});
		}
		
	}
	
	/*
	public static void bfs(int x, int count) {
		System.out.println(x + ", " + count);
		if(x == K) {
			ans = count;
			return;
		}
		
		if(count > ans)
			return;
		
		if(x * 2 < K)
			bfs(x * 2, count+1);
		else if(x < K) {
			bfs(x + 1, count+1);
			bfs(x * 2, count+1);
		}
		else
			bfs(x-1, count+1);
	}
	*/
}

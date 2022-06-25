package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//¼û¹Ù²ÀÁú
public class b_1697 {

	static int ans = Integer.MAX_VALUE, K;
	static int[] count = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		K = sc.nextInt();
		
        if(N == K)
            ans = 0;
        else
		    bfs(N);
        
		System.out.println(ans);
		sc.close();
	}

	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		count[x] = 1;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			System.out.println(temp + " "  + count[temp]);
			
			if(temp == K) {
				ans = count[temp] - 1;
				return;
			}
			
			for(int i = 0; i < 3; i++) {
				int next;
				
				if(i == 0)
					next = temp + 1;
				else if(i == 1)
					next = temp - 1;
				else
					next = temp * 2;
				
				if(next >= 0 && next <= 100000 && count[next] == 0) {
					count[next] = count[temp] + 1;
					q.add(next);
				}
			}
			
//			q.add(new int[] {temp[0] + 1, temp[1] + 1});
//			q.add(new int[] {temp[0] - 1, temp[1] + 1});
//			q.add(new int[] {temp[0] * 2, temp[1] + 1});
		}
		
	}
	
}

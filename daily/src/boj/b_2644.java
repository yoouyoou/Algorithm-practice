package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//ÃÌ¼ö °è»ê
public class b_2644 {

	static ArrayList[] list;
	static boolean[] visited;
	static int n2, flag = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for(int i = 1; i <= n; i++)
			list[i] = new ArrayList<Integer>();
		
		String[] str = br.readLine().split(" ");
		int n1 = Integer.parseInt(str[0]);
		n2 = Integer.parseInt(str[1]);
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++) {
			str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			list[x].add(y);
			list[y].add(x);
		}

		dfs(n1, 0);
		if(flag == 0)
			System.out.println("-1");
	}
	
	public static void dfs(int x, int total) {
		visited[x] = true;
		
		if(x == n2) {
			System.out.println(total);
			flag = 1;
			return;
		}
		
		for(int i = 0; i < list[x].size(); i++) {
			int next = (int)list[x].get(i);
			if(!visited[next])
				dfs(next, total+1);
		}
		
	}

}

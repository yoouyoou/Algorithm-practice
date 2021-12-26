package practice;

import java.util.Scanner;

public class practice {

	static int moveX[] = {0,1,0,-1}; 
	static int moveY[] = {1,0,-1,0};
	static int grid[][];
	static int count = 0;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //격자 개수
		n = n+1;
		grid = new int[n][n];
		
		grid[0][0] = 1;
		DFS(0, 0);
		System.out.println(count);
		sc.close();
	}
	
	public static void DFS(int x, int y) {
		if(x == n-1 && y == n-1) {
			count++;
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nx = x + moveX[i];
			int ny = y + moveY[i];
			if(0 <= nx && nx < n && 0 <= ny && ny < n) {
				if(grid[nx][ny] == 0) {
					grid[nx][ny] = 1;
					DFS(nx, ny);
					grid[nx][ny] = 0;
				}
					
			}
		}
	}
	
	/*
	public static void dfs(int x, int y) {
		if(visited[x][y])
			return;
		visited[x][y] = true;
		
		if(x == n && y == n)
			rslt++;
		
		for(int i = 0; i < 4; i++) {
			int newX = x + moveX[i];
			int newY = y + moveY[i];
			
            if (newX < 0 || newY < 0 || newX > n || newY > n)
                continue;
            
            dfs(newX, newY);
		}
	}
	*/

}

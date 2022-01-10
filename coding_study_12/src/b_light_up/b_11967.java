package b_light_up;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// 골드3
public class b_11967 {
	
	static int count = 0;
	static int N;
	static int[] moveX = {-1, 1, 0, 0};	//상하좌우
	static int[] moveY = {0, 0, -1, 1};
	static boolean[][] grid, visited;
	static ArrayList<String>[] list;
	static HashMap<String, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		int temp = 1;
		
		list = new ArrayList[M+1];
		grid = new boolean[N+1][N+1];
		visited = new boolean[N+1][N+1];
		map = new HashMap<>();
		
		for(int i = 1; i <= M; i++)
			list[i] = new ArrayList<String>();

		// 각 요소 입력받아 배열에 저장
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			String xy = x + "," + y;
			String ab = a + "," + b;
			
			if(!map.containsKey(xy))
				map.put(xy, temp++);
			
			list[map.get(xy)].add(ab);
		}
		
		grid[1][1] = true;
		DFS(1, 1);
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		
		
		System.out.println(count);
		sc.close();
	}

	// 현재 방에서 킬 수 있는 불 다 켜기
	public static void current_light(int x, int y) {
		if(map.containsKey(x+","+y)) {
			for(String next : list[map.get(x+","+y)]) {
				int nextX = Integer.parseInt(next.split(",")[0]);
				int nextY = Integer.parseInt(next.split(",")[1]);
				if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= N) {
					grid[nextX][nextY] = true;
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void DFS(int x, int y) {
		System.out.println(x + " " +y);
		if(grid[x][y] == false || visited[x][y] == true)	//불이 꺼져 있거나 이미 방문했던 곳이라면
			return;											//바로 리턴
		
		visited[x][y] = true;	//방문표시
		current_light(x, y);	//여기서 켤 수 있는 방의 불 모두 켜기
		
		for(int k = 0; k < 4; k++) {
			int nx = x + moveX[k];
			int ny = y + moveY[k];
			if(nx > 0 && nx <= N && ny > 0 && ny <= N && grid[nx][ny]) //움직일 수 있는 곳이 true여야 함-불켜져있어야
				DFS(nx, ny);
		}
	}
	
	/*
	public static void DFS(int x, int y) {
		//System.out.println("x: " + x + " y :" + y);
		if(grid[x][y])
			return;
		
		grid[x][y] = true;
		count++;
		
		if(map.containsKey(x+","+y)) {
			for(String next : list[map.get(x+","+y)]) {
				int nextX = Integer.parseInt(next.split(",")[0]);
				int nextY = Integer.parseInt(next.split(",")[1]);
				if(nextX > 0 && nextX <= N && nextY > 0 && nextY <= N)
					DFS(nextX, nextY);
			}
		}
	}
	*/
	
}

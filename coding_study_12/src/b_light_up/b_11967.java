package b_light_up;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

// 골드3
public class b_11967 {
	
	static int answer = 0;
	static int[][] grid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int temp = 1;
		grid = new int[N+1][N+1];
		String[] xy_arr = new String[M];
		String[] ab_arr = new String[M];
		HashMap<String, Integer> map = new HashMap<>();

		// 각 요소 입력받아 배열에 저장
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			String xy = x + "," + y;
			String ab = a + "," + b;
			xy_arr[i] = xy;
			ab_arr[i] = ab;
			
			if(!map.containsKey(xy))
				map.put(xy, temp++);
		}
		
		// 입력 배열 (1,1)를 맨 앞으로
		for(int i = 0; i < M; i++) {
			if(xy_arr[i].equals("1,1")) {
				String temp2 = xy_arr[0];
				xy_arr[0] = xy_arr[i];
				xy_arr[i] = temp2;
				break;
			}
		}
				
		
		// grid 시작점 채우기
		for(int i = 0; i < M; i++) {
			int t1 = Integer.parseInt(xy_arr[i].split(",")[0]);
			int t2 = Integer.parseInt(xy_arr[i].split(",")[1]);
			grid[t1][t2] = map.get(xy_arr[i]);
		}
		
		// grid 연결점 채우기
		for(int i = 0; i < M; i++) {
			int t1 = Integer.parseInt(ab_arr[i].split(",")[0]);
			int t2 = Integer.parseInt(ab_arr[i].split(",")[1]);
			if(grid[t1][t2] > 0) {
				map.replace(ab_arr[i], map.get(xy_arr[i]));
			}
			grid[t1][t2] = map.get(xy_arr[i]);
		}
		
		// grid 시작점 채우기
		for(int i = 0; i < M; i++) {
			int t1 = Integer.parseInt(xy_arr[i].split(",")[0]);
			int t2 = Integer.parseInt(xy_arr[i].split(",")[1]);
			grid[t1][t2] = map.get(xy_arr[i]);
		}
		
		int ans = map.get("1,1");
		for(int i = 0; i < M; i++)
			if(map.get(xy_arr[i]) == ans)
				answer++;

		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(answer);
		sc.close();
	}

}

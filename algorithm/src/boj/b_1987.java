package boj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class b_1987 {

	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static int R, C;
	static char[][] arr;
	static boolean[][] visited;
	static Set<Character> set;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		visited = new boolean[R][C];
		set = new HashSet<>();
		
		for(int i = 0; i < R; i++) {
			String str = sc.next();
			for(int j = 0; j < C; j++)
				arr[i][j] = str.charAt(j);
		}
		
		set.add(arr[0][0]);
		visited[0][0] = true;
		solution(0, 0, 1);
		
		System.out.println(max);
	}
	
	public static void solution(int r, int c, int count) {
		System.out.println("arr["+r+"]["+c+"] = " + arr[r][c] + " ==> count " + count);
		max = Math.max(max, count);
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			System.out.println("next: " + nr + ","+nc);
			
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(!visited[nr][nc] && !set.contains(arr[nr][nc])){
					set.add(arr[nr][nc]);
					visited[nr][nc] = true;
					System.out.println("solution ÀçÈ£Ãâ");
					solution(nr, nc, count + 1);
					visited[nr][nc] = false;
					set.remove(arr[nr][nc]);
				}
			}
		}
		
	}

}

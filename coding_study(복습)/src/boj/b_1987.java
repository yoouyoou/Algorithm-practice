package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//알파벳
public class b_1987 {

	static int R, C;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] board;
	static boolean[][] visited;
	static boolean[] alphabet;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		
		R = Integer.parseInt(temp[0]);
		C = Integer.parseInt(temp[1]);
		board = new char[R][C];
		visited = new boolean[R][C];
		alphabet = new boolean[26];
		
		for(int i = 0; i < R; i++) {
			String temp2 = br.readLine();
			for(int j = 0; j < C; j++)
				board[i][j] = temp2.charAt(j);
		}
		
		dfs(0, 0, 0);
		System.out.println(answer);
		
	}
	
	public static void dfs(int x, int y, int total) {
		if(visited[x][y])
			return;
		
		if(answer < total)
			answer = total;
		
		visited[x][y] = true; 	//방문 표시
		alphabet[board[x][y] - 65] = true;
		answer++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx > 0 && nx < R && ny >0 && ny < C) {
				if(!alphabet[board[nx][ny] - 65])
					dfs(nx, ny, total+1);
			}
			
			alphabet[board[x][y] - 65] = false;
			visited[x][y] = false;
		}
			
	}

}

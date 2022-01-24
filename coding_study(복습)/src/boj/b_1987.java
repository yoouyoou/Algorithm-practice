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
		System.out.println(answer+1);
		
	}
	
	public static void dfs(int x, int y, int total) {
		visited[x][y] = true; 				//방문 표시
		alphabet[board[x][y] - 65] = true;	//알파벳 사용표시
		
		System.out.println("[" + x + "]" + "[" + y +"] :" +total);
		System.out.println("--------------------------");
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visited[i][j])
					System.out.print("T ");
				else
					System.out.print("F ");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		
		if(answer < total)
			answer = total;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			//System.out.println("nx, ny값: " + nx +", "+ny);
			
			if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if(alphabet[board[nx][ny] - 65] == false && visited[nx][ny] == false) {
					dfs(nx, ny, total+1);
					alphabet[board[nx][ny] - 65] = false;
					visited[nx][ny] = false;
				}
			}
		}	
	}

}

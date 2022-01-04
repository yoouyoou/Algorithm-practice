package b_alphabet;

import java.util.Scanner;

//골드4
public class b_1987 {
	
	static char[][] board;
	static int[] dx = {-1, 1, 0, 0};			// 상하우좌
	static int[] dy = {0, 0, 1, -1};
	static int R, C;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		board = new char[R][C];
		boolean[] visited = new boolean[26]; // 알파벳 개수
		
		for(int i = 0; i < R; i++) {
			String str = sc.next();
			for(int j = 0; j < str.length(); j++)
				board[i][j] = str.charAt(j);
		}
		
		dfs(0, 0, visited, 0);
		System.out.println(answer);
		sc.close();
	}
	
	public static void dfs(int r, int c, boolean[] visited, int count) {
		System.out.println(count);
		if(answer < count)		// 최대 알파벳 방문개수 구하기 위해
			answer = count;
		
		if(visited[board[r][c]-'A'] == true)	// 알파벳 이미 방문한 경우 리턴
			return;	
		
		visited[board[r][c]-'A'] = true;		// 방문 표시
		//path.add(board[r][c]);
		
		for(int i = 0; i < 4; i++) {			
			int x = r + dx[i];
			int y = c + dy[i];
			
			if(x >= 0 && x < R && y < C && y >= 0) {
				dfs(x, y, visited, count+1);
			}
		}
		visited[board[r][c]-'A'] = false;
		
	}

}

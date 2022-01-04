package b_alphabet;

import java.util.Scanner;

//���4
public class b_1987 {
	
	static char[][] board;
	static int[] dx = {-1, 1, 0, 0};			// ���Ͽ���
	static int[] dy = {0, 0, 1, -1};
	static int R, C;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		board = new char[R][C];
		boolean[] visited = new boolean[26]; // ���ĺ� ����
		
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
		if(answer < count)		// �ִ� ���ĺ� �湮���� ���ϱ� ����
			answer = count;
		
		if(visited[board[r][c]-'A'] == true)	// ���ĺ� �̹� �湮�� ��� ����
			return;	
		
		visited[board[r][c]-'A'] = true;		// �湮 ǥ��
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

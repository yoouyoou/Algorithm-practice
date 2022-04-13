package 이코테;

public class dfs {

	static int[] dr = {-1, 1, 0, 0};	//상하좌우
	static int[] dc = {0, 0, -1, 1};
	static int n, m;
	static boolean[][] visited;
	static int[][] map = {{0,0,1,1,0},
			{0,0,0,1,1},
			{1,1,1,1,1},
			{0,0,0,0,0}};;
	
	public static void main(String[] args) {
		n = 4;
		m = 5;
		visited = new boolean[n][m];
		
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					dfs(i, j);
					ans++;
				}
			}
		}

		System.out.println(ans);
	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nr < n && nc >=0 && nc < m)
				if(!visited[nr][nc] && map[nr][nc]==0)
					dfs(nr, nc);
		}
	}

}

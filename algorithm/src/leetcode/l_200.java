package leetcode;

public class l_200 {
	
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static boolean[][] visited;
	static char[][] grid;
	static int N, M;

	public static void main(String[] args) {
		//1:땅  0:물
		char[][] grid = {
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}
		};
		
		System.out.println(numIslands(grid));
	}
	
    public static int numIslands(char[][] grid2) {
    	grid = grid2;
    	N = grid.length;
    	M = grid[0].length;
    	visited = new boolean[N][M];
    	int ans = 0;
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(grid[i][j] == '1' && !visited[i][j]) {	//땅이고 방문 안한 경우
    				dfs(i, j);
    				ans++;
    			}
    		}
    	}
    	
    	return ans;
        
    }
    
    public static void dfs(int r, int c) {
    	if(r < 0 || r >= N || c < 0 || c >= M || grid[r][c] == '0' || visited[r][c])
    		return;

    	visited[r][c] = true;
    	
    	for(int i = 0; i < 4; i++)
    		dfs(r + dr[i], c + dc[i]);
    		
    }


}

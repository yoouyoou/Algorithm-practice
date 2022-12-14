package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_417 {

	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {1, -1, 0, 0};
	static int[][] dp, grid;
	static int n, m;
	
	public static void main(String[] args) {
//		int[][] test = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		int[][] test = {{1,1},{1,1},{1,1}};
		
		for(List<?> a: pacificAtlantic(test))
			System.out.println(a.get(0) + ", " + a.get(1));
	}
	
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	m = heights.length;
    	n = heights[0].length;
    	
    	dp = new int[m][n];
    	grid = new int[m][n];
    	grid = heights;
    	
    	for(int i = 0; i < n; i++)	//북쪽 P
    		dfs(0, i, 1);
    	
    	for(int i = 0; i < m; i++)	//서쪽 P
    		dfs(i, 0, 1);
    	
    	for(int i = 0; i < n; i++)	//남쪽 A
    		dfs(m-1, i, 2);
    	
    	for(int i = 0; i < m; i++)
    		dfs(i, n-1, 2);			//동쪽 A
    	
    	printarr();
    	
    	for(int r = 0; r < m; r++) {
    		for(int c = 0; c < n; c++) {
    			if(dp[r][c] == 3)
    				ans.add(new ArrayList<Integer>(Arrays.asList(r, c)));
    		}
    	}
    	
        return ans;
    }
    
    public static void dfs(int r, int c, int value) {
   	    if(dp[r][c] == value || dp[r][c] == 3)
    		return;

    	dp[r][c] += value;
    	
    	for(int i = 0; i < 4; i++) {
    		int nr = r + dr[i];
    		int nc = c + dc[i];
    		
            //격자 내이고 해수면 이상인 경우
    		if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[r][c] <= grid[nr][nc]) {
                if(dp[nr][nc] < value)
                    dfs(nr, nc, value);
    		}
    	}
    	
    }
    
    public static void printarr() {
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++)
    			System.out.print(dp[i][j] +" ");
    		System.out.println();
    	}
    	System.out.println();
    }

}

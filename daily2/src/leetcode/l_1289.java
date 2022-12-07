package leetcode;

public class l_1289 {
	
	public static void main(String[] args) {
//		int[][] mat = {
//				{1,2,3},
//				{4,5,6},
//				{7,8,9}
//		};
		
//		int[][] mat = {
//				{2,2,1,2,2},
//				{2,2,1,2,2},
//				{2,2,1,2,2},
//				{2,2,1,2,2},
//				{2,2,1,2,2}
//		};
		
		int[][] mat = {
				{11,28,-35,-96,73},
				{15,-83,82,-51,-11},
				{-49,1,42,-95,53},
				{63,52,-19,15,-89},
				{-80,60,90,25,-50}
		};
		
		System.out.println(minFallingPathSum(mat));
	}
	
    public static int minFallingPathSum(int[][] grid) {
    	int min = Integer.MAX_VALUE;
    	int n = grid.length;
    	int[][] dp = new int[n][n];
    	
    	for(int r= 0; r < n; r++){
    		for(int c = 0; c < n; c++) {
    			if(r == 0)
    				dp[r][c] = grid[r][c];
    			else {
    				
    				if(c==0)
    					dp[r][c] = dp[r-1][1] + grid[r][c];
    				else if(c== n-1)
    					dp[r][c] = dp[r-1][n-2] + grid[r][c];
    				else
    					dp[r][c] = dp[r-1][c-1] + grid[r][c];
    				
    				for(int i = 0; i < n; i++)
    					if(i != c)
    						dp[r][c] = Math.min(dp[r][c], grid[r][c] + dp[r-1][i]);
    			}
    			
        		if(r == n-1)
        			min = Math.min(min, dp[r][c]);
    		}
    	}
    	
        return min;
    }


}

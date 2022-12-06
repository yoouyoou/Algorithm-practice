package leetcode;

public class l_931 {

	public static void main(String[] args) {
		int[][] mat = {
				{2, 1, 3},
				{6, 5, 4},
				{7, 8, 9}
		};
		
		System.out.println(minFallingPathSum(mat));
	}
	
    public static int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        
        for(int r = 0; r < n; r++) {
        	for(int c = 0; c < m; c++) {
            	if(r == 0)	//첫번째 행은 그대로 넣기
            		dp[r][c] = matrix[r][c];
            	else {
            		dp[r][c] = matrix[r][c] + dp[r-1][c];
            		
            		if(c-1 >= 0)
            			dp[r][c] = Math.min(dp[r-1][c-1] + matrix[r][c], dp[r][c]);
            		if(c+1 < m)
            			dp[r][c] = Math.min(dp[r-1][c+1] + matrix[r][c], dp[r][c]);
            		
            	}
            	
            	if(r == n-1)
            		min = Math.min(min, dp[r][c]);
        	}
        }
        
        return min;
    }

}

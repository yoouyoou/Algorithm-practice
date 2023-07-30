package leetcode;

public class l_688 {

	public static void main(String[] args) {
		System.out.println(knightProbability(3,2,0,0));
	}
	
	// 체스판에 말이 남아있을 확률
	public static double knightProbability(int n, int k, int row, int column) {
        int[][] moves = {{-1,-2},{-2,-1}, {-2,1},{-1,2}, {1,-2},{2,-1}, {2,1},{1,2}};
        double[][] dp = new double[n][n];	//말이 해당 칸에 남아있을 확률
        double answer = 0.0;
        
        dp[row][column] = 1;
        
        if(k == 0)	// 움직이지 않을 경우 무조건 체스판 안에 남아있으므로
        	return (double) 1;
        
        for(int i = 0; i < k; i++) {
        	double[][] temp = new double[n][n];
        	
        	//해당 칸에서 갈 수 있는 곳의 확률 넣어버리기
        	for(int r = 0; r < n; r++) {
        		for(int c = 0; c < n; c++) {
        			if(dp[r][c] != 0) {
        				for(int[] move : moves) {
        					int dr = r + move[0];
        					int dc = c + move[1];
        					if(dr >= 0 && dr < n && dc >= 0 && dc < n)
        						temp[dr][dc] += dp[r][c] * 0.125;		//곱하기 8분의 1
        				}
        			}
        		}
        	}
        	
        	for(int r = 0; r < n; r++)
        		for(int c = 0; c < n; c++)
        			dp[r][c] = temp[r][c];
        }
        
        for(int i = 0; i < n; i++)
        	for(int j = 0; j < n; j++)
        		answer += dp[i][j];
        
        return answer;
    }
}

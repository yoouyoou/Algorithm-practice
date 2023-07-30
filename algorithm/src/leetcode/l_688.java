package leetcode;

public class l_688 {

	public static void main(String[] args) {
		System.out.println(knightProbability(3,2,0,0));
	}
	
	// ü���ǿ� ���� �������� Ȯ��
	public static double knightProbability(int n, int k, int row, int column) {
        int[][] moves = {{-1,-2},{-2,-1}, {-2,1},{-1,2}, {1,-2},{2,-1}, {2,1},{1,2}};
        double[][] dp = new double[n][n];	//���� �ش� ĭ�� �������� Ȯ��
        double answer = 0.0;
        
        dp[row][column] = 1;
        
        if(k == 0)	// �������� ���� ��� ������ ü���� �ȿ� ���������Ƿ�
        	return (double) 1;
        
        for(int i = 0; i < k; i++) {
        	double[][] temp = new double[n][n];
        	
        	//�ش� ĭ���� �� �� �ִ� ���� Ȯ�� �־������
        	for(int r = 0; r < n; r++) {
        		for(int c = 0; c < n; c++) {
        			if(dp[r][c] != 0) {
        				for(int[] move : moves) {
        					int dr = r + move[0];
        					int dc = c + move[1];
        					if(dr >= 0 && dr < n && dc >= 0 && dc < n)
        						temp[dr][dc] += dp[r][c] * 0.125;		//���ϱ� 8���� 1
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

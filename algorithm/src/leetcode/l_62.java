package leetcode;

public class l_62 {
	
	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));
	}

    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(i == 0 || j == 0)
        			arr[i][j] = 1;
        		else
        			arr[i][j] = arr[i][j-1] + arr[i-1][j];
        	}
        }
        
        return arr[m-1][n-1];
    }
}

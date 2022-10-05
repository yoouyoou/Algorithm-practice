package programmers;

public class 행렬테두리회전하기 {

	static int[][] grid;
	
	public static void main(String[] args) {
		int r = 6;
		int c = 6;
		int[][] q = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		for(int a: solution(r, c, q))
			System.out.print(a + " ");
	}
	
    public static int[] solution(int rows, int columns, int[][] queries) {
    	grid = new int[rows][columns];
    	int[] answer = new int[queries.length];
    	int idx = 1;
    	
    	for(int r = 0; r < rows; r++)
    		for(int c = 0; c < columns; c++)
    			grid[r][c] = idx++;
    	
    	idx = 0;
    	for(int i = 0; i < queries.length; i++)
    		answer[idx++] = rotation(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1);
    	
        return answer;
    }
    
    public static int rotation(int r1, int c1, int r2, int c2) {
    	int t1 = grid[r1][c1], t2 = grid[r1][c2];
    	int t3 = grid[r2][c1], t4 = grid[r2][c2];
    	
    	int min = Integer.MAX_VALUE;
    	boolean flag = false;
    	int temp, before;
    	
    	//r1행 이동
    	before = t1;
    	for(int i = c1 + 1; i <= c2; i++) {
    		min = Math.min(min, before);
    		if(flag) {
    			temp = grid[r1][i];
    			grid[r1][i] = before;
    			before = temp;
    		} 
    		else {
    			temp = grid[r1][i];
    			grid[r1][i] = before;
    			before = temp;
    			flag = true;
    		}
    	}
    	
    	//c2열 이동
    	flag = false;
    	before = t2;
    	for(int i = r1 + 1; i <= r2; i++) {
    		min = Math.min(min, before);
    		if(flag) {
    			temp = grid[i][c2];
    			grid[i][c2] = before;
    			before = temp;
    		}else {
    			temp = grid[i][c2];
    			grid[i][c2] = before;
    			before = temp;
    			flag = true;
    		}
    	}

    	//r2행 이동
    	flag = false;
    	before = t4;
    	for(int i = c2 - 1; i >= c1; i--) {
    		min = Math.min(min, before);
    		temp = grid[r2][i];
    		if(flag) {
    			grid[r2][i] = before;
    			before = temp;
    		}else {
    			grid[r2][i] = before;
    			before = temp;
    			flag = true;
    		}
    	}
    	
    	//c1행 이동
    	flag = false;
    	before = t3;
    	for(int i = r2 - 1; i >= r1; i--) {
    		min = Math.min(min, before);
    		temp = grid[i][c1];
    		if(flag) {
    			grid[i][c1] = before;
    			before = temp;
    		}else {
    			grid[i][c1] = before;
    			before = temp;
    			flag = true;
    		}
    	}
    	
    	return min;
    }

}

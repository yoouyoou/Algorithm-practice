package leetcode;

public class l_498 {
	
	public static void main(String[] args) {
		int[][] mat = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		
		for(int a: findDiagonalOrder(mat)) {
			System.out.print(a + " ");
		}
	}
	
    public static int[] findDiagonalOrder(int[][] mat) {
    	int m = mat.length, n = mat[0].length;
    	int[] list = new int[m * n];
    	int idx = 0, curX = 0, curY = 0;
        boolean flag = true;		//true-위로,  false-아래로

        while(true) {
   
            while(curX < m && curX >=0 && curY < n && curY >= 0) {
            	System.out.print("["+curX + ", " + curY + "]  ");
            	list[idx++] = mat[curX][curY];
            	
            	if(flag) {
            		curX -= 1;
            		curY += 1;
            	}
            	else {
            		curX += 1;
            		curY -= 1;
            	}
            }
            System.out.println();
            
            if(flag) {
            	curX += 1;
            	curY -= 1;
            	if(curY < n-1)
            		curY += 1;
            	else
            		curX += 1;
            	flag = false;
            }
            else {
            	curX -= 1;
            	curY += 1;
            	if(curX < m-1)
            		curX += 1;
            	else
            		curY += 1;
            	flag = true;
            }    
            
            if(idx == m * n)
            	break;
        }
        
        return list;
    }

}

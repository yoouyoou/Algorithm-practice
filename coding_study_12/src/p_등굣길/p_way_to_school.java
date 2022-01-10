package p_µî±·±æ;

public class p_way_to_school {

	public static void main(String[] args) {
		int m = 5;
		int n = 3;
		int[][] puddles = {{4,2}};

		
        int[][] area = new int[n+1][m+1];
        for(int i = 0; i < puddles.length; i++)
            area[puddles[i][1]][puddles[i][0]] = -1;
        
        for(int i = 1; i <= m; i++){
            if(area[1][i] == -1)
                break;
            area[1][i] = 1;
        }
        
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(area[i][j] == -1)
                    continue;
                if(area[i-1][j] > -1)
                    area[i][j] += area[i-1][j];
                if(area[i][j-1] > -1)
                    area[i][j] += area[i][j-1];
            }
        }
        
        for(int i = 0; i <= n; i++) {
        	for(int j = 0; j <= m; j++)
        		System.out.print(area[i][j]+" ");
        	System.out.println();
        }
	}

}

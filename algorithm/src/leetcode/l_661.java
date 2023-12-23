package leetcode;

public class l_661 {

	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) {
		int[][] test = {{100,200,100},{200,50,200},{100,200,100}};
//		int[][] test2 = {{1,1,1},{1,0,1},{1,1,1}};
		
		int[][] result = imageSmoother(test);
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}
	
	public static int[][] imageSmoother(int[][] img) {
		int m = img.length, n = img[0].length;
        int[][] answer = new int[m][n];
        
        for(int x = 0; x < m; x++) {
        	for(int y = 0; y < n; y++) {
        		System.out.print("<" + x + ","+ y + ">\n" + img[x][y] + " + ");
        		int temp = img[x][y];
        		int cnt = 1;
        		
        		for(int i = 0; i < 8; i++) {
        			int nx = x + dx[i];
        			int ny = y + dy[i];
        			if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
        				System.out.print(img[nx][ny] + " + ");
            			temp += img[nx][ny];
            			cnt++;
            		}
        		}
        		System.out.println("\n" + temp + "/" + cnt + "=" + (int) Math.floor(temp / cnt));
        		answer[x][y] = (int) Math.floor(temp / cnt);
        	}
        }
        
        return answer;
    }

}

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//숫자 배열 회전
public class s_1961 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = 1;
		int testcase = Integer.parseInt(br.readLine());
		for(int t = 0; t < testcase; t++) {			
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(str[j]);
			}
			
			int[][] rotation_90 = rotation(map);
			int[][] rotation_180 = rotation(rotation_90);
			int[][] rotation_270 = rotation(rotation_180);
			
			System.out.println("#" + tc++);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) 
					System.out.print(rotation_90[i][j]);
				
				System.out.print(" ");
				for(int j = 0; j < N; j++) 
					System.out.print(rotation_180[i][j]);
				
				System.out.print(" ");
				for(int j = 0; j < N; j++) 
					System.out.print(rotation_270[i][j]);
				
				System.out.println();
			}
		}
	}
	
	public static int[][] rotation(int[][] map) {
		int N = map.length;
		int[][] ans = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			int temp = N-1;
			for(int j = 0; j < N; j++)
				ans[i][j] = map[temp--][i];
		}
		
		return ans;
	}
	
}

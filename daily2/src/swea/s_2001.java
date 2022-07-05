package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ÆÄ¸® ÅðÄ¡
public class s_2001 {

	static int tc = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		for(int t = 0; t < testcase; t++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(str[j]);
			}
			
			solution(map, N, M);
		}

	}
	
	public static void solution(int[][] map, int N, int M) {
		int ans = 0;
		
		for(int i = 0; i <= N - M; i++) {
			for(int j = 0; j <= N - M; j++) {
				int sum = 0;
				for(int a = 0; a < M; a++) {
					for(int b = 0; b < M; b++) {
						sum += map[i+a][j+b];
						System.out.print(map[i+a][j+b] + " ");
					}
					System.out.println();
				}

				ans = Math.max(ans, sum);
			}
		}
		
		System.out.println("#" + tc++ + " " + ans);
				
	}

}

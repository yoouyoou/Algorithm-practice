package swea;

import java.util.Scanner;

public class s_1979 {

	static int tc = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int t = 0; t < testcase; t++) {
			int N = sc.nextInt();	//격자 길이
			int K = sc.nextInt();	//단어 길이
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) 
				for(int j = 0; j < N; j++)
					map[i][j] = sc.nextInt();
			
			solution(map, N, K);
		}

		sc.close();
	}
	
	public static void solution(int[][] map, int N, int K) {
		int ans = 0;
		
		//가로 확인
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					int count = 0;
					while(j < N && map[i][j] == 1) {
						j++;
						count++;
					}
					if(count == K)
						ans++;
				}
			}
		}
		
		//세로 확인
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[j][i] == 1) {
					int count = 0;
					while(j < N && map[j][i] == 1) {
						j++;
						count++;
					}
					if(count == K)
						ans++;
				}
			}
		}
		
		System.out.println("#" + tc++ + " " + ans);
	}

}

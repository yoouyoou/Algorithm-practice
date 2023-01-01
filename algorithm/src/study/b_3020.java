package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b_3020 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
//		boolean[][] map = new boolean[H][N];
		int[][] map = new int[H][N];
		boolean flag = true;	//true:석순(밑부터)
		
		//동굴 입력
		for(int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			
			if(flag) {
				for(int r = H-1; r >= H-temp; r--) {
					map[r][i] = 1;//true;
				}
				flag = false;
			}
			else {
				for(int r = 0; r < temp; r++)
					map[r][i] = 1; //true;
				flag = true;
			}
		}
		
		/* 배열 확인 
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}*/
		
		int min = Integer.MAX_VALUE;
		//int[] part = new int[N+1];
		for(int i = 0; i < H; i++) {
			int cnt = 0;
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1)
					cnt++;
			}
			if(i == 0)
				Arrays.fill(map[0], 0);
			min = Math.min(min, cnt);
			map[0][cnt]++;
		}
		
		System.out.println(min + " " + map[0][min]);
		
	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//롤러코스터
public class b_2873 {

	static int R, C;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < C; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
		
		

	}

}

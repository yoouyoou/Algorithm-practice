package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//¿¬±¸¼Ò (°ñµå5)
public class b_14502 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}

	}

}

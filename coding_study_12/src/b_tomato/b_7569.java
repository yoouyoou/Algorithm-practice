package b_tomato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//½Ç¹ö1
public class b_7569 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][][] box = new int[M][N][H];
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					st = new StringTokenizer(br.readLine());
					box[n][m][h] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
	}

}

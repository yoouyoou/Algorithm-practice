package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//뉴스 전하기
public class b_1135 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i] = Integer.parseInt(str[i]);
		}
		
	}

}

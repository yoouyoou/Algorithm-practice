package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//경사로
public class b_14890 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//input
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int L = Integer.parseInt(str[1]);
		int[][] map = new int[N][N];
		int answer = 0;
		boolean isAnswer = false, isLow = false;
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt( str[j] );
			}
		}
		
		//행 검사
		for(int i = 0; i < N; i++) {
			int cur = map[i][0];
			int curlen = 1;
			isAnswer = false;
			
			for(int j = 1; j < N; j++) {
				System.out.println("행검사(" + i + ", " + j +")");
				//기존값이랑 달라짐
				if(cur != map[i][j]) {
					if(isLow && !(curlen >= L)) 
						break;
					// 올라가는 경우
					if(map[i][j] - cur == 1) {	
						if(curlen >= L) {
							cur = map[i][j];
							curlen = 1;
						}
						else
							break;
					}
					//내려가는 경우
					else if(cur - map[i][j] == 1) { 
						isLow = true;
						cur = map[i][j];
						curlen = 1;
					}
					else
						break;
					
					if(Math.abs(map[i][j] - cur) == 1 && curlen >= L) {
						if(map[i][j] < cur)
							isLow = true;
						cur = map[i][j];
						curlen = 1;
						continue;
					}
					else {
						System.out.println("절대값 차가 1이 아니거나 경사로 길이가 L보다 작아서 행반복 탈출");
						break;
					}
				}
				curlen++;
				if(j == N-1)
					isAnswer = true;
				if(isLow && curlen >= L)
					isAnswer = false;
			}
			if(isAnswer) {
				System.out.println(i + "행 에서 answer증가");
				answer++;
			}
		}
		
		System.out.println("행검사 완료: " + answer);
		
		//열 검사
		for(int i = 0; i < N; i++) {
			int cur = map[0][i];
			int curlen = 1;
			isAnswer = false;
			
			for(int j = 1; j < N; j++) {
				//기존값이랑 달라짐
				if(cur != map[j][i]) {
					if(Math.abs(map[j][i] - cur) == 1 && curlen >= L) {
						cur = map[j][i];
						curlen = 1;
						continue;
					}
					else
						break;
					
				}
				curlen++;
				if(j == N-1)
					isAnswer = true;
			}
			if(isAnswer) {
				System.out.println(i + "열 에서 answer증가");
				answer++;
			}
		}
		
		System.out.println(answer);
		br.close();	
	}

}

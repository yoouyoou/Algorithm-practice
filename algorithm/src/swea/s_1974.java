package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//스도쿠 검증
public class s_1974 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < testcase; t++) {
			//input
			int[][] map = new int[9][9];
			for(int i = 0; i < 9; i++) {
				String[] str = br.readLine().split(" ");				
				for(int j = 0; j < 9; j++) 
					map[i][j] = Integer.parseInt(str[j]);
			}
			
			System.out.println(solution(map));
		}
	}
	
	public static int solution(int[][] map) {
		//solution
		int[] count1 = new int[10];
		boolean[][] count2 = new boolean[9][10];
		boolean[] part1 = new boolean[10];
		boolean[] part2 = new boolean[10];
		boolean[] part3 = new boolean[10];
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				//가로줄 확인
				if(count1[map[i][j]] == i+1)
					return 0;
				else
					count1[map[i][j]] = i+1;
					
				//세로줄 확인
				if(count2[j][map[i][j]]) 
					return 0;
				else
					count2[j][map[i][j]] = true;
				
				//작은 격자 확인
				if(i == 3 || i == 6) {
					Arrays.fill(part1, false);
					Arrays.fill(part2, false);
					Arrays.fill(part3, false);
				}

				if(i >= 0 && i <= 2) {
					if(j >= 0 && j < 3) {
						if(part1[map[i][j]])
							return 0;
						else
							part1[map[i][j]] = true;
					}
					else if(j >= 3 && j < 6) {
						if(part2[map[i][j]]) 
							return 0;
						else
							part2[map[i][j]] = true;
					}
					else {
						if(part3[map[i][j]]) 
							return 0;
						else
							part3[map[i][j]] = true;
					}
				}
				else if(i >= 3 && i <= 5) {
					if(j >= 0 && j < 3) {
						if(part1[map[i][j]])
							return 0;
						else
							part1[map[i][j]] = true;
					}
					else if(j >= 3 && j < 6) {
						if(part2[map[i][j]]) 
							return 0;
						else
							part2[map[i][j]] = true;
					}
					else {
						if(part3[map[i][j]]) 
							return 0;
						else
							part3[map[i][j]] = true;
					}
				}
				else {
					if(j >= 0 && j < 3) {
						if(part1[map[i][j]])
							return 0;
						else
							part1[map[i][j]] = true;
					}
					else if(j >= 3 && j < 6) {
						if(part2[map[i][j]]) 
							return 0;
						else
							part2[map[i][j]] = true;
					}
					else {
						if(part3[map[i][j]]) 
							return 0;
						else
							part3[map[i][j]] = true;
					}
				}
			}
		}
		
		return 1;
	}
	

}

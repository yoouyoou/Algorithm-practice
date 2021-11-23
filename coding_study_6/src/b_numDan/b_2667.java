package b_numDan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class b_2667 {

	static int[][] dan;
	static boolean[][] visited;
	static int[] moveY = {-1, 1, 0, 0};
	static int[] moveX = {0, 0, -1, 1};		// ←, →, ↑, ↓
	static int total = 0;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String data;
		N = sc.nextInt();
		dan = new int[N][N];
		visited = new boolean[N][N];
		ArrayList<Integer> answer = new ArrayList<>();
//		int[] answer = new int[30];
//		int t = 0;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			data = sc.next();
			String[] d = data.split("");
			for(int j = 0; j < N; j++)
				dan[i][j] = Integer.parseInt(d[j]);
		}
		
		/* 입력확인
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				System.out.print(dan[i][j] + " ");
			System.out.println();
		}*/
		sc.close();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && dan[i][j] != 0) {
					dfs(i, j);
					//System.out.println(total);
					//answer[t++] = total;
					answer.add(total);
					total = 0;
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(answer);
		for(int c : answer)
			System.out.println(c);
//		런타임 에러
//		Arrays.sort(answer, 0, cnt);
//		System.out.println(cnt);
//		for(int i = 0; answer[i] != 0; i++)
//			System.out.println(answer[i]);
		
	}
	
	public static void dfs(int x, int y) {
		if(visited[x][y] == true || dan[x][y] == 0)
			return;
		
		//System.out.println("방문dan: " + x + ", " + y + " : " + total);
		visited[x][y] = true;
		total++;
		
		for(int i = 0; i < 4; i++) {
			int newX = x + moveY[i];
			int newY = y + moveX[i];

			if(newX < 0 || newX >= N || newY < 0 || newY >= N) 
				continue;
			
			if(visited[newX][newY] == false && dan[newX][newY] != 0)
				dfs(newX, newY);
		}
	}

}

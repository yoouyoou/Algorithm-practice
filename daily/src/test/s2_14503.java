package test;

import java.io.*;
import java.util.StringTokenizer;

//로봇 청소기
public class s2_14503 {

	static int N, M, ans = 0;
	static int[][] map;
	static int[][] move = {{0, -1, 0, 1}, {-1, 0, 1, 0}};	//보고있는 방향에 따른 이동방향 
	
	static int dy[] = {-1,0,1,0}; // 북동남서
	static int dx[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());	//현재 좌표
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());	//현재 바라보고 있는 방향
		
		//input
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//청소하는 칸의개수 출력
		dfs(r, c, d);
		System.out.println(ans + 1);
	}
			
	public static void dfs(int r, int c, int d) {
		map[r][c] = -1;	//현재 위치 청소
		//ans++;
		
		//현재 방향기준으로 왼쪽방향으로 탐색 진행
		int i = 0;
		for(i = 0; i < 4; i++) {
			int nr = r + move[0][d];
			int nc = c + move[1][d];
			if(d == 0)
				d = 3;
			else
				d -= 1;
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {	//격자 내이고
				if(map[nr][nc] == 0) {	//청소되지 않은 빈칸으로 이동해서 다시 dfs실행
					ans++;
					dfs(nr, nc, d);
					return;
				}
			}
		}
		
		//네 방향 모두 청소가 되어있거나 뒤쪽 방향 외에 모두 벽인 경우 
		//현재 방향 그대로 한 칸 후진
		int idx;
		if(d == 0)
			idx = 3;
		else
			idx = d-1;
		int nr = r + move[0][idx];
		int nc = c + move[1][idx];
			
		if(nr >= 0 && nr < N && nc >= 0 && nc < M)
			if(map[nr][nc] != 1)	//벽만 아니라면 후진이 가능함
				dfs(nr, nc, d);
	}

}

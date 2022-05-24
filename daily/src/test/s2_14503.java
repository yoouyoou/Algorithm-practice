package test;

import java.io.*;
import java.util.StringTokenizer;

//�κ� û�ұ�
public class s2_14503 {

	static int N, M, ans = 0;
	static int[][] map;
	static int[][] move = {{0, -1, 0, 1}, {-1, 0, 1, 0}};	//�����ִ� ���⿡ ���� �̵����� 
	
	static int dy[] = {-1,0,1,0}; // �ϵ�����
	static int dx[] = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());	//���� ��ǥ
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());	//���� �ٶ󺸰� �ִ� ����
		
		//input
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//û���ϴ� ĭ�ǰ��� ���
		dfs(r, c, d);
		System.out.println(ans + 1);
	}
			
	public static void dfs(int r, int c, int d) {
		map[r][c] = -1;	//���� ��ġ û��
		//ans++;
		
		//���� ����������� ���ʹ������� Ž�� ����
		int i = 0;
		for(i = 0; i < 4; i++) {
			int nr = r + move[0][d];
			int nc = c + move[1][d];
			if(d == 0)
				d = 3;
			else
				d -= 1;
			
			if(nr >= 0 && nr < N && nc >= 0 && nc < M) {	//���� ���̰�
				if(map[nr][nc] == 0) {	//û�ҵ��� ���� ��ĭ���� �̵��ؼ� �ٽ� dfs����
					ans++;
					dfs(nr, nc, d);
					return;
				}
			}
		}
		
		//�� ���� ��� û�Ұ� �Ǿ��ְų� ���� ���� �ܿ� ��� ���� ��� 
		//���� ���� �״�� �� ĭ ����
		int idx;
		if(d == 0)
			idx = 3;
		else
			idx = d-1;
		int nr = r + move[0][idx];
		int nc = c + move[1][idx];
			
		if(nr >= 0 && nr < N && nc >= 0 && nc < M)
			if(map[nr][nc] != 1)	//���� �ƴ϶�� ������ ������
				dfs(nr, nc, d);
	}

}

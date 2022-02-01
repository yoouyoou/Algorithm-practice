package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//������ (���5)
public class b_14502 {

	static int N, M, minCount = Integer.MAX_VALUE, count = -1;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
		
		DFS(0);
		System.out.println(N * M - minCount);
		br.close();
	}
	
	public static void DFS(int num) {
		if(num == 3) {
			visited = new boolean[N][M];
			if(count < minCount && count != -1)
				minCount = count;
			//System.out.println(minCount);
			count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2) 		//���̷��� �߽߰�
						virus(i, j);		//�������
					else if(map[i][j] == 1)	//���� ���
						count++;			//�� ���� ����
				}
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {		//map���鼭
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {		// ���������
					map[i][j] = 1;			// ������ ���
					DFS(num + 1);			// �� ���� ���ʷ� �� ����
					map[i][j] = 0;			//
				}
			}
		}
	}
	
	public static void virus(int r, int c) {		
		visited[r][c] = true;	//�湮ǥ��
		count++;				//���̷��� ���� ����(��,���̷��� ���� ����)
		
		for(int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !visited[nr][nc])
				virus(nr, nc);
		}
	}

}

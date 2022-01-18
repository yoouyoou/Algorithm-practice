package b_tomato;

import java.util.Scanner;

//�ǹ�1
public class b_7569 {

	static int[] dh = {0, 0, 0, 0, -1, 1};	//������
	static int[] dr = {-1, 1, 0, 0, 0, 0};	//��
	static int[] dc = {0, 0, -1, 1, 0, 0};	//��
	static int M, N, H;
	static int[][][] box;
	static boolean[][][] visited;
	static int before_ripe, after_ripe;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		box = new int[H][N][M];	//������,��,��
		visited = new boolean[H][N][M];
		
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					box[h][n][m] = sc.nextInt();
				}
			}
		}

		/*���
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					System.out.print(box[h][n][m]);
				}
				System.out.println();
			}
			System.out.println();
		}*/
		
		//1:���� �丶��, 0:�������� �丶��, -1: �丶�����
		//while(confirm() == false) {
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(box[h][n][m] == 1)
						dfs(h, n, m);
				}
			}
		}
		//}
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					System.out.print(box[h][n][m]);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println(before_ripe);
		sc.close();
	}
	
	public static void dfs(int h, int r, int c) {
		if(box[h][r][c] == -1)	//�丶�� ������ ����
			return;
		
		if(box[h][r][c] == 0) {	//�������� �丶���� ���
			box[h][r][c] = 1;	//�͵��� ����
			before_ripe++;
		}
		
		visited[h][r][c] = true;
		
		for(int i = 0; i < 6; i++) {
			int nh = h + dh[i];
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nh>0 && nh<H && nr>0 && nr<N && nc>0 && nc<M)
				if(!visited[nh][nr][nc])
					dfs(nh, nr, nc);
		}
	}
	
	public static boolean confirm() {
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(box[h][n][m] == 0)
						return false;	//������
				}
			}
		}
		return true;		//������
	}

}

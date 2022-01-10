package b_iceberg;

import java.util.Scanner;

// 골드4
public class b_2573 {

	static int[] moveX = {-1, 1, 0, 0};	//상하좌우
	static int[] moveY = {0, 0, -1, 1};
	static int N, M;
	static int[][] ice;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer, count = 0;
		N = sc.nextInt();
		M = sc.nextInt();
		ice = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				ice[i][j] = sc.nextInt();
		
		while(true) {
			visited = new boolean[N][M];
			afterYear();
			count++;
			answer = isDivide();
			if(answer != -1)
				break;
		}
		if(answer == 0)
			System.out.println("0");
		else
			System.out.println(count);
		sc.close();		
	}
	
	public static void afterYear() {
		int[][] melt = new int[N][M];		//녹을 빙산 개수
		
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				if(ice[x][y] > 0) {
					for(int k = 0; k < 4; k++) {
						int nextX = x + moveX[k];
						int nextY = y + moveY[k];
						if(nextX >= 0 && nextX <= N && nextY >= 0 && nextY <= M && ice[nextX][nextY]==0)
							melt[x][y] += 1;
					}
				}
			}
		}

		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				if(melt[x][y] > 0) {
					ice[x][y] -= melt[x][y];
					if(ice[x][y] < 0)
						ice[x][y] = 0;
				}
			}
		}
		
		/*System.out.println("1년 후의 빙산");
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) 
				System.out.print(ice[x][y] +" ");
			System.out.println();
		}*/
	}
	
	public static void DFS(int x, int y) {
		if(visited[x][y] == true || ice[x][y] == 0)
			return;
		
		visited[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + moveX[i];
			int ny = y + moveY[i];
			if(nx >= 0 && nx <= N && ny >=0 && ny <= M)
				DFS(nx, ny);
		}
	}
	
	public static int isDivide() {
		int count = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(ice[i][j] > 0 && visited[i][j] == false) {
					DFS(i, j);
					count++;
				}

		if(count > 1)
			return count;			//2개 이상으로 분리됨
		else if(count == 0)		//아예 순회를 하지 않음. 고로 빙산이 다 녹았다는 뜻
			return 0;
		else
			return -1;			//아직 한 덩이의 빙산으로 남아있음 
	}

}

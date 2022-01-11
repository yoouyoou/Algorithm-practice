package b_light_up;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// ���3
public class b_11967 {
	
	static int count = 0;
	static int N;
	static int[] moveX = {0,0,1,-1};		//�����¿�
	static int[] moveY = {1,-1,0,0};
	static boolean[][] grid, visited;		//���� �������� �� �� �ִ� �迭, 
	static ArrayList<String>[] list;
	static ArrayList<String> waiting = new ArrayList<>();
	static HashMap<String, Integer> map;
	static Queue<String> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		int M = sc.nextInt();
		int temp = 1;
		
		list = new ArrayList[M+1];
		grid = new boolean[N+1][N+1];
		visited = new boolean[N+1][N+1];
		map = new HashMap<>();
		
		for(int i = 1; i <= M; i++)
			list[i] = new ArrayList<String>();

		// �� ��� �Է¹޾� �迭�� ����
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			String xy = x + "," + y;
			String ab = a + "," + b;
			
			if(!map.containsKey(xy))
				map.put(xy, temp++);
			
			list[map.get(xy)].add(ab);
		}
		
		grid[1][1] = true;
		DFS(1,1);
		
		/*���� Ȯ�� ���
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				System.out.print(grid[i][j] + " ");
			System.out.println();
		}*/
			
		System.out.println(count+1);
		sc.close();
	}

	// �ش� �濡�� �����¿� Ȯ���ϰ� �� �� �ִ� �� ���� ���ѱ�
	public static void DFS(int x, int y) {
		if(visited[x][y] == true)					// �̹� �湮�ߴ� ���̶��
			return;									//�ٷ� ����
		
		visited[x][y] = true;	//�湮ǥ��
		current_light(x, y);	//���⼭ �� �� �ִ� ���� �� ��� �ѱ�
		
		for(int k = 0; k < 4; k++) {
			int nx = x + moveX[k];
			int ny = y + moveY[k];
			if(nx > 0 && nx <= N && ny > 0 && ny <= N && !visited[nx][ny]) {
				if(grid[nx][ny]) //������ �� �ִ� ���� true���� ��-�������־��
					DFS(nx, ny);
				else
					waiting.add(nx+","+ny);
			}
		}
		
		for(int i = 0; i < waiting.size(); i++) {
			int a = Integer.parseInt(waiting.get(i).split(",")[0]);
			int b = Integer.parseInt(waiting.get(i).split(",")[1]);
			if(grid[a][b] && !visited[a][b])
				DFS(a,b);
		}
	}
	
	// ���� �濡�� ų �� �ִ� �� �� �ѱ�
	public static void current_light(int x, int y) {
		if(map.containsKey(x+","+y)) {
			for(String next : list[map.get(x+","+y)]) {
				int nextX = Integer.parseInt(next.split(",")[0]);
				int nextY = Integer.parseInt(next.split(",")[1]);
				if(!grid[nextX][nextY]) {
					//System.out.println(nextX+" "+nextY+" ī��Ʈ ����");
					grid[nextX][nextY] = true;
					count++;
				}
			}
		}
	}
}

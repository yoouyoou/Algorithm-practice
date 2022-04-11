package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���ǿ� ��ȸ
public class b_2098 {

	static int[][] w;
	static int N;
	static boolean[] visited;
	static int ans = 0, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		w = new int[N][N];
		visited = new boolean[N];
				
		//input
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				w[i][j] = Integer.parseInt(str[j]);
		}
		
		//solution
		dfs(0, 1);	//0�� ���ú��� �湮����
		System.out.println(min);
	}
	
	public static void dfs(int x, int num) {
		System.out.print("���� �湮 ����: " + x + " ("+num+"��°)");
		
		if(num == N) {	//��� �湮�� �Ϸ�Ǿ���
			if(min > ans + w[x][0]) {
				min = ans + w[x][0];
//				System.out.println("min��: " + min + "����!");
			}
			return;
		}
		
		visited[x] = true;	//�湮 ǥ��
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && w[x][i] != 0 && i != x) {	//�湮����
//				System.out.println("-> " + i);
				ans += w[x][i];
				dfs(i, num+1);
				visited[i] = false;
				ans -= w[x][i];
			}
		}
		visited[x] = false;
		return;
	}

}

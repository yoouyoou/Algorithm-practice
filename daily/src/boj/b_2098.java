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
		if(num == N) {	//��� �湮�� �Ϸ�Ǿ���
			if(min > ans + w[x][0])
				min = ans;
			return;
		}
			
		//visited�迭�� ��� �� ��츦 �����ϴµ� ��
		visited[x] = true;
		
		for(int i = 0; i < N; i++) {
			if(!visited[i] && w[x][i] != 0) {	//�湮����
				ans += w[x][i];
				dfs(i, num+1);
				visited[x] = false;
				ans -= w[x][i];
			}
		}
//		visited[x] = false;
		return;
	}

}

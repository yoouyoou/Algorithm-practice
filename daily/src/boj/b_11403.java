package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//��� ã��(�ǹ�1)
public class b_11403 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] G = new int[N+1][N+1];
		
		//input
		for(int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				if(i == j) 
					G[i][j] = 1;
				G[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		//solution
		for(int k = 1; k <= N; k++) {		//k��° ��带 ���� ���� ���
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(G[i][k] == 1 && G[k][j] == 1)
						G[i][j] = 1;
		}
		
		//output
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++)
				System.out.print(G[i][j] + " ");
			System.out.println();
		}
		
	}
	
	//ó�� �����ߴ� ��: Set�̿��Ͽ� �ش� �� ���� �� �� �ִ� �� ��� �ֱ� 
	//��� ���� i���� j�� ��ĥ �� ���� �� j���� �Ļ��Ǵ� ���� ���� i�࿡�� 1�� �ٲٱ�
}

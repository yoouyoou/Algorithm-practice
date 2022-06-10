package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� ����
public class b_1976 {

	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] plan = new int[M];
		parent = new int[N+1];
		
		for(int i = 1; i <= N; i++)
			parent[i] = i;
		
		for(int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				if(str[j-1].equals("1")) {
					union(i, j);
					System.out.println(i + "�� " + j + "��ħ");
				}
			}
		}
		
		String[] str = br.readLine().split(" ");
		for(int i = 0; i < M; i++)
			plan[i] = Integer.parseInt(str[i]);
		
		// -> �ش� ���� ��ȹ�� ���鸸 ���� �����̸� ���� ������� �� �� �� �ִ�
		boolean ans = true;
		int standard = find(plan[0]);
		
		for(int i = 1; i < M; i++) {
			if(standard != find(plan[i])) {
				ans = false;
				break;
			}
		}
		
		if(ans)
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
}
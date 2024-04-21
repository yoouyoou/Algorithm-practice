package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_2529 {

	static int k;
	static char[] Inequality;
	static boolean[] visited;
	static String ans1, ans2;
	static boolean flag1 = true, flag2 = true;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		Inequality = new char[k];	//�ε�ȣ �迭
		visited = new boolean[10];	//0~9 ���� ���迭
		
		String str = br.readLine();
		String[] strs = str.split(" ");
		for(int i = 0; i < k; i++)
			Inequality[i] = strs[i].charAt(0);
		
		//�ִ�����
		DFS1("", 0);
		System.out.println(ans1);
		
		//�ּ�����
		DFS2("", 0);
		System.out.println(ans2);
	}
	
	public static void DFS1(String num, int idx) {
		if(idx == k + 1) {
			ans1 = num;
			flag1 = false;
			return;
		}
		
		if(!flag1) return;
		
		for(int i = 9; i >= 0; i--) {
			if(!visited[i] && flag1) {
				if(idx == 0 || isPossible(num.charAt(idx-1), i, Inequality[idx-1])) {
					visited[i] = true;
					DFS1(num+i, idx+1);
					visited[i] = false;
				}
			}
		}
	}
	
	// �ּ����� ���ϱ�
	public static void DFS2(String num, int idx) {
		if(idx == k + 1) {
			ans2 = num;
			flag2 = false;
			return;
		}
		
		if(!flag2) return;
		
		for(int i = 0; i < 10; i++) {
			if(!visited[i] && flag2) {
				if(idx == 0 || isPossible(num.charAt(idx-1), i, Inequality[idx-1])) {
					visited[i] = true;
					DFS2(num+i, idx+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static boolean isPossible(char a, int b, char c) {
		int an = Character.getNumericValue(a);
		if(c == '<')
			if(an > b) return false;
		if(c == '>')
			if(an < b) return false;
		return true;
	}

}

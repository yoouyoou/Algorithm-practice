package study;

import java.util.Scanner;

//�ؼ�
public class b_24231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++)
			arr[i] = str.charAt(i);

		//1. �������� �� ���� �ε��� ����
		//2. �� ���� �ε��� ���̰� 0 or 2�� ������ ������ ��츸 üũ
		//3. �� ���� �ε����� 01/10���� Ȯ�� �� ans�� ����
		
	}
	
	public static void comb(int n, int c, boolean[] visited) {
		
	}
	
	public static boolean isPossible(char c1, char c2) {
		if(c1 == '0' && c2 == '1')
			return true;
		else if(c1 == '1' && c2 == '0')
			return true;
		else
			return false;
	}

}

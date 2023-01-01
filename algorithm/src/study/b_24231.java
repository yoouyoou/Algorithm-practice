package study;

import java.util.Scanner;

//해석
public class b_24231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] arr = new char[str.length()];
		
		for(int i = 0; i < str.length(); i++)
			arr[i] = str.charAt(i);

		//1. 조합으로 두 개의 인덱스 고르기
		//2. 두 개의 인덱스 사이가 0 or 2로 나누어 떨어질 경우만 체크
		//3. 두 개의 인덱스가 01/10인지 확인 후 ans값 증가
		
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

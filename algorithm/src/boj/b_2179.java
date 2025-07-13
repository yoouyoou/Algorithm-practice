package boj;

import java.util.Scanner;

public class b_2179 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max = 0;
		String str1 = "", str2 = "";
		String[] keywords = new String[N];
		
		for(int i = 0; i < N; i++)
			keywords[i] = sc.next();
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				int countKeyword = countWord(keywords[i], keywords[j]);
				if(countKeyword > max) {
					max = countKeyword;
					str1 = keywords[i];
					str2 = keywords[j];
				}
			}
		}
		if(max == 0) {
			System.out.println(keywords[0]);
			System.out.println(keywords[1]);
		}else {
			System.out.println(str1);
			System.out.println(str2);
		}
		sc.close();
	}
	
	//부분 문자열 구하는 함수
	public static int countWord(String s1, String s2) {
		int count = 0;
		
		for(int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
			if(s1.charAt(i) == s2.charAt(i))
				count++;
			else
				break;
		}
		
		return count;
	}
}

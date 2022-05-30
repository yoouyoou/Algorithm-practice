package boj;

import java.util.ArrayList;
import java.util.Scanner;

//키로거
public class b_5397 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String str;
		
		for(int i = 0; i < t; i++) {
			str = sc.next();
			solution(str);
		}
		
		sc.close();
	}
	
	public static void solution(String str) {
		int idx = 0;	//idx는 그 다음 글자가 들어갈 list의 인덱스 값을 가리킴
		ArrayList<Character> list = new ArrayList<>();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
					
			if(ch == '<') {
				if(idx > 0)
					idx--;
			}
			else if(ch == '>') {
				if(idx < list.size())
					idx++;
			}
			else if(ch == '-') {
				if(idx > 0) {
					idx--;
					list.remove(idx);
				}
			}
			else {
				list.add(idx, ch);
				idx++;
			}
		}
		
		for(char c: list)
			System.out.print(c);	
	}

}

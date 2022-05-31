package boj;

//import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//Å°·Î°Å
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
		LinkedList<Character> lnklist = new LinkedList<>();
		ListIterator<Character> list = lnklist.listIterator();
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
				
			switch(ch) {
			case '<':
				if(list.nextIndex() > 0)
					list.previous();
				break;
				
			case '>':
				if(list.nextIndex() < lnklist.size())
					list.next();
				break;
				
			case '-':
				if(list.nextIndex() > 0) {
					list.previous();
					list.remove();
				}
				break;
				
			default:
				list.add(ch);
				break;
			}
			
			/*
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
			*/
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c: lnklist)
			sb.append(c);
		System.out.println(sb.toString());
	}

}

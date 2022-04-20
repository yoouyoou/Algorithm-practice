package boj;

import java.util.Scanner;
import java.util.Stack;

public class b_9935 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String boom = sc.next();
		Stack<Character> stack = new Stack<Character>();

		for(int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			//스택 사이즈가 폭발문자열만큼이 찼고, 스택 마지막 문자가 폭발문자열 마지막 문자와 같음 
			if(stack.size() >= boom.length() && stack.peek() == boom.charAt(boom.length()-1)) {
				//반대로 내려가면서 폭발문자열과 같은지 확인
				boolean isBoom = true;
				
				for(int j = 0; j < boom.length(); j++) {
					if(stack.get(stack.size()-boom.length()+j) != boom.charAt(j)) {
						isBoom = false;
						break;
					}
				}
				
				if(isBoom) {
					for(int j = 0; j < boom.length(); j++)
						stack.pop();
				}
			}
		
		}
		
		if(stack.size() == 0)
			System.out.println("FRULA");
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < stack.size(); i++)
				sb.append(stack.get(i));
			
			System.out.println(sb.toString());	
		}
	}

}

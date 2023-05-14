package boj;

import java.util.Scanner;
import java.util.Stack;

public class b_27930 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		
		stack1.push('I'); stack1.push('E'); stack1.push('S');
		stack1.push('N'); stack1.push('O'); stack1.push('Y');
		
		stack2.push('A'); stack2.push('E'); stack2.push('R');
		stack2.push('O'); stack2.push('K');
		
		String S = sc.next();
		
		for(int i = 0; i < S.length(); i++) {
			if(stack1.peek() == S.charAt(i))
				stack1.pop();
			
			if(stack2.peek() == S.charAt(i))
				stack2.pop();
			
			if(stack1.isEmpty()) {
				System.out.println("YONSEI");
				return;
			}
			if(stack2.isEmpty()) {
				System.out.println("KOREA");
				return;
			}
		}
		
	}

}

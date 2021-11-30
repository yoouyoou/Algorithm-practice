package b_reverseWord;

import java.util.Scanner;
import java.util.Stack;

// 실버3
public class b_17413 {

	public static void main(String[] args) {
		//입력받기
		Scanner sc = new Scanner(System.in);
		String answer = "";
		String str = sc.nextLine();
		
		//solution
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<>();
		boolean tag = false;
		
		for(int i = 0; i < arr.length; i++) {
			if(tag) {
				if(arr[i] == '>')
					tag = false;
				answer += arr[i];
			}
			else if(arr[i] == '<') {
				while(!stack.empty())
					answer += stack.pop();
				answer += arr[i];
				tag = true;
			}
			else if(arr[i] == ' ') {
				while(!stack.empty())
					answer += stack.pop();
				answer += arr[i];
			}
			else {
				stack.push(arr[i]);
			}
		}
		
		while(!stack.empty())
			answer += stack.pop();
		
		System.out.println(answer);
		sc.close();
	}

}

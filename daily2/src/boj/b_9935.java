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
			
			//���� ����� ���߹��ڿ���ŭ�� á��, ���� ������ ���ڰ� ���߹��ڿ� ������ ���ڿ� ���� 
			if(stack.size() >= boom.length() && stack.peek() == boom.charAt(boom.length()-1)) {
				//�ݴ�� �������鼭 ���߹��ڿ��� ������ Ȯ��
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

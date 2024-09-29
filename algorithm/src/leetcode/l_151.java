package leetcode;

import java.util.Stack;

public class l_151 {

	public static void main(String[] args) {
		String s1 = "the sky is blue";
		String s2 = "  hello world  ";
		String s3 = "a good   example";
		
		System.out.println(reverseWords(s1));
		System.out.println(reverseWords(s2));
		System.out.println(reverseWords(s3));
	}
	
	public static String reverseWords(String s) {
		Stack<String> stack = new Stack<>();
        String[] str = s.split("");
        String answer = "";
        
        for(int i = 0; i < str.length; i++) {
        	String temp = "";
        	
        	System.out.println("\n반복시작");
        	while(!str[i].equals(" ")) {
        		System.out.print(str[i] + " ");
        		temp += str[i++];
        		
        		if(i >= str.length)
        			break;
        	}
        	
        	if(!temp.equals(""))
        		stack.push(temp);
        	temp = "";
        }
        
        while(!stack.isEmpty()) {
        	if(stack.size() == 1)
        		answer += stack.pop();
        	else
        		answer += stack.pop() + " ";
        }
        
        return answer;
    }

}

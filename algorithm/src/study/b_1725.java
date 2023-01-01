package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//히스토그램
public class b_1725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	//히스토그램 개수
		int[] height = new int[N+2];				//히스토그램 높이
		
		long answer = 0;
		Stack<Integer> stack = new Stack<>();		//히스토그램 인덱스 담을 스택

		height[0] = 0;
		height[N] = 0;
		
		for(int i = 1; i <= N; i++) 
			height[i] = Integer.parseInt(br.readLine());
		
		//아 인덱스를 넣어야 하는 이유 알겠음: 작큰작큰 이런식으로 예전에 스택에 들어온 막대까지 추후 계산할때 인덱스로 봐야하기 때문

		stack.push(0);
		System.out.println("스택에 0넣음");
		
		for(int i = 1; i <= N+1; i++) {
			while(!stack.isEmpty()) {
				int top = stack.peek();
				
				if(height[top] <= height[i])
					break;
				
				System.out.println(top + "제거");
				stack.pop();
				answer = Math.max(answer, height[top] * (i-stack.peek()-1));
				System.out.println(height[top] * (i-stack.peek()-1));
			}
			
			stack.push(i);
			System.out.println("스택에 "+i+"넣음");
		}
		
		System.out.println(answer);

	}

}

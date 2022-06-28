package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//히스토그램
public class b_1725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long answer = 0;
		Stack<Integer> stack = new Stack<>();		//막대의 인덱스 담을 스택
		int N = Integer.parseInt(br.readLine());	//가로 칸 수
		int[] height = new int[N+1];
		height[N] = -1;
		
		for(int i = 0; i < N; i++) 
			height[i] = Integer.parseInt(br.readLine());
		
		//아 인덱스를 넣어야 하는 이유 알겠음: 작큰작큰 이런식으로 예전에 스택에 들어온 막대까지 추후 계산할때 인덱스로 봐야하기 때문

		int stand = height[0];
		stack.push(0);
		System.out.println("스택에  0넣음");
		
		for(int i = 1; i <= N; i++) {
			if(stand > height[i]) {
				
				while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
					int t = stack.pop();
					System.out.print("스택"+t+"확인 :");
					System.out.println(height[t] + " * " + (i - 1 - t + 1));
					answer = Math.max(answer, height[t] * (i - 1 - t + 1));
					System.out.println("answer: " + answer);
				}
			}
			
			stack.push(i);
			stand = height[i];
			System.out.println("스택에 "+i+"넣음");
		}
		
		System.out.println(answer);

	}

}

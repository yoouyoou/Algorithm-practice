package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//������׷�
public class b_1725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());	//������׷� ����
		int[] height = new int[N+2];				//������׷� ����
		
		long answer = 0;
		Stack<Integer> stack = new Stack<>();		//������׷� �ε��� ���� ����

		height[0] = 0;
		height[N] = 0;
		
		for(int i = 1; i <= N; i++) 
			height[i] = Integer.parseInt(br.readLine());
		
		//�� �ε����� �־�� �ϴ� ���� �˰���: ��ū��ū �̷������� ������ ���ÿ� ���� ������� ���� ����Ҷ� �ε����� �����ϱ� ����

		stack.push(0);
		System.out.println("���ÿ� 0����");
		
		for(int i = 1; i <= N+1; i++) {
			while(!stack.isEmpty()) {
				int top = stack.peek();
				
				if(height[top] <= height[i])
					break;
				
				System.out.println(top + "����");
				stack.pop();
				answer = Math.max(answer, height[top] * (i-stack.peek()-1));
				System.out.println(height[top] * (i-stack.peek()-1));
			}
			
			stack.push(i);
			System.out.println("���ÿ� "+i+"����");
		}
		
		System.out.println(answer);

	}

}

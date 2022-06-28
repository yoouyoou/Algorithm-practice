package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//������׷�
public class b_1725 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long answer = 0;
		Stack<Integer> stack = new Stack<>();		//������ �ε��� ���� ����
		int N = Integer.parseInt(br.readLine());	//���� ĭ ��
		int[] height = new int[N+1];
		height[N] = -1;
		
		for(int i = 0; i < N; i++) 
			height[i] = Integer.parseInt(br.readLine());
		
		//�� �ε����� �־�� �ϴ� ���� �˰���: ��ū��ū �̷������� ������ ���ÿ� ���� ������� ���� ����Ҷ� �ε����� �����ϱ� ����

		int stand = height[0];
		stack.push(0);
		System.out.println("���ÿ�  0����");
		
		for(int i = 1; i <= N; i++) {
			if(stand > height[i]) {
				
				while(!stack.isEmpty() && height[stack.peek()] > height[i]) {
					int t = stack.pop();
					System.out.print("����"+t+"Ȯ�� :");
					System.out.println(height[t] + " * " + (i - 1 - t + 1));
					answer = Math.max(answer, height[t] * (i - 1 - t + 1));
					System.out.println("answer: " + answer);
				}
			}
			
			stack.push(i);
			stand = height[i];
			System.out.println("���ÿ� "+i+"����");
		}
		
		System.out.println(answer);

	}

}

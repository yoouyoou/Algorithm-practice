package boj;

import java.util.Scanner;

//����(���� Ǫ�� ����)
public class b_1292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();

		boolean flag = false;
		int idx = 0, answer = 0;
		
		for(int i = 1; i <= B; i++) {
			idx += i;
			
			if(idx >= B && flag) {
				// (idx - i + 1) : i������ ���� �ε���
				answer += (B - (idx - i + 1) + 1) * i;
				break;
			}
			
			if(flag) 
				answer += i * i;
			
			if(idx >= A && !flag) {
				answer += (idx - A + 1) * i;
				flag = true;
				if(idx >= B) {	//���� i���� ���� �ִ� ��� ó��
					answer = (B - A + 1) * i;
					break;
				}
			}
		
		}
		
		System.out.println(answer);		
	}

}

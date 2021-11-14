package b_AtoB;

import java.util.Scanner;

public class b_16953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 1;
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int Blast = B % 10;		// B ������ �ڸ���
		
		//���ʿ� 2�� ���ϰų� 1�� �ٿ��� ���� �� ���� ��
		if(Blast == 3 || Blast== 5 || Blast == 7 || Blast == 9)
			answer = -1;
		else
			answer = solution(A, B, answer);
		
		System.out.println(answer);
		sc.close();
	}
	
	// ��ʹ� �ð� �� �׷��� ȿ���������� ������ ���� �ݺ���..! <- ���ؿ� �ø��ڵ尡 �� ���� ��
	public static int solution(int A, int B, int answer) {
		int Blast = B % 10;
		
		if(A == B)
			return answer;
		else if(B < A)
			return -1;
		else if(Blast == 3 || Blast== 5 || Blast == 7 || Blast == 9)
			return -1;
		else {
			if(Blast == 1) {	// �������� 1�� �������
				B /= 10;		// ������ 1����
				answer++;		// ����Ƚ�� ����
				return solution(A, B, answer);
			}
			else {				// else�� �ȵǴ� ����? ���ڸ��� 1�� �ƴϸ� ����� �ü��� ������
				B /= 2;
				answer++;
				return solution(A, B, answer);
			}
		}
	}

}

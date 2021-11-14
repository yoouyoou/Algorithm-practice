package b_AtoB;

import java.util.Scanner;

public class b_16953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int answer = 1;
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int Blast = B % 10;		// B 마지막 자릿수
		
		//애초에 2를 곱하거나 1을 붙여서 나올 수 없는 수
		if(Blast == 3 || Blast== 5 || Blast == 7 || Blast == 9)
			answer = -1;
		else
			answer = solution(A, B, answer);
		
		System.out.println(answer);
		sc.close();
	}
	
	// 재귀는 시간 상 그렇게 효율적이지는 않은듯 차라리 반복문..! <- 백준에 올린코드가 더 좋은 거
	public static int solution(int A, int B, int answer) {
		int Blast = B % 10;
		
		if(A == B)
			return answer;
		else if(B < A)
			return -1;
		else if(Blast == 3 || Blast== 5 || Blast == 7 || Blast == 9)
			return -1;
		else {
			if(Blast == 1) {	// 마지막이 1로 끝날경우
				B /= 10;		// 마지막 1떼고
				answer++;		// 연산횟수 증가
				return solution(A, B, answer);
			}
			else {				// else가 안되는 이유? 끝자리가 1이 아니면 어떤수든 올수가 있을껄
				B /= 2;
				answer++;
				return solution(A, B, answer);
			}
		}
	}

}

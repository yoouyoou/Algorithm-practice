package boj;

import java.util.Scanner;

//구현(쉽게 푸는 문제)
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
				// (idx - i + 1) : i숫자의 시작 인덱스
				answer += (B - (idx - i + 1) + 1) * i;
				break;
			}
			
			if(flag) 
				answer += i * i;
			
			if(idx >= A && !flag) {
				answer += (idx - A + 1) * i;
				flag = true;
				if(idx >= B) {	//같은 i구간 내에 있는 경우 처리
					answer = (B - A + 1) * i;
					break;
				}
			}
		
		}
		
		System.out.println(answer);		
	}

}

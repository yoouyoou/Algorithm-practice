package boj;

import java.util.Scanner;

public class b_4796 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = 1, P = 1, V = 1;
		int answer = 0, temp = 1;
		
		while(true) {
			L = sc.nextInt();
			P = sc.nextInt();
			V = sc.nextInt();
			
			if(L == 0 && P == 0 && V == 0)
				break;
			
			answer = (V / P) * L;
			if((V % P) > L)
				answer += L;
			else
				answer += V % P;
			
			System.out.println("Case " + temp + ": " + answer);
			temp++;
		}
	}

}

package boj;

import java.util.Scanner;

public class b_1439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean zero = false, one = false;
		int cntZero = 0, cntOne = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			char cur = s.charAt(i);
			
			if(cur == '0') {
				if(one) {
					one = false;
					cntOne++;
				}
				zero = true;
			}
			else {
				if(zero) {
					zero = false;
					cntZero++;
				}
				one = true;
			}
			
			if(i == s.length()-1) {
				if(zero)
					cntZero++;
				else
					cntOne++;
			}
		}
		
		System.out.println(Math.min(cntZero, cntOne));	
		sc.close();
	}

}

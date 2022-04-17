package boj;

import java.util.Scanner;

//¹®ÀÚ¿­ ¿¬½À
public class b_9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String bombs = sc.next();
//		String[] str = s.split("");
//		String[] bstr = bombs.split("");
		boolean isDiffer = true;
//		String ans = "";
		char[] ans = new char[str.length()];
		int idx = 0;
		
		while(isDiffer) {
			isDiffer = false;
			idx = 0;
			for(int i = 0; i < str.length(); i++) {
//				System.out.println("str: " + str[i]);
				
				for(int j = 0; j < bombs.length(); j++) {
//					System.out.println("ÆøÅº °Ë»ç: " + bstr[j]);
					if(str.charAt(i+j) != bombs.charAt(j))
						break;
					if(j == bombs.length() - 1) {
						i += bombs.length();
						isDiffer = true;
					}
				}
				if(i < str.length())
					ans[idx++] = str.charAt(i);
//					ans += str.charAt(i);
			}
			str = String.valueOf(ans, 0, idx);
//			System.out.println("ans: " + ans);
		}
		
		String answer = String.valueOf(ans, 0, idx);
		if(answer.length() == 0)
			answer = "FRULA";
		System.out.println(answer);

	}

}

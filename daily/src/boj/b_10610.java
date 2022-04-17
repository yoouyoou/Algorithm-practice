package boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class b_10610 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.next();
		String[] n = N.split("");
		
		boolean isZero = false;
		String ans = "";
		int sum = 0;
		for(int i = 0; i < n.length; i++) {
			if(n[i].equals("0"))
				isZero = true;
			sum += Integer.parseInt(n[i]);
		}
		
		//System.out.println(sum);

		if(sum % 3 == 0 && isZero) {
			Arrays.sort(n, Collections.reverseOrder());
			for(int i = 0; i < n.length; i++)
				ans += n[i];
		}
		else
			ans = "-1";
		
		System.out.println(ans);
	}

}

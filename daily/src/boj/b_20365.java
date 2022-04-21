package boj;

import java.util.Scanner;

public class b_20365 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String list = sc.next();

		int num = 1;
		for(int i = 1; i < N; i++)
			if(list.charAt(i-1) != list.charAt(i))
				num++;
		
		/*
		char[] ch = new char[N];
		ch[0] = list.charAt(0);
		
		int num = 1;
		for(int i = 1; i < N; i++) {
			if(list.charAt(i-1) != list.charAt(i)) {
				ch[i] = list.charAt(i);
				num++;
			}
		}*/

		if(num == 1)
			System.out.println("1");
		else if(num == 2)
			System.out.println("2");
		else if(num % 2 == 0)	//짝수면 첫글자와 막글자가 다름
			System.out.println(num/2+1);
		else					//홀수면 같음
			System.out.println((num-1)/2 + 1);
		
		sc.close();
	}

}

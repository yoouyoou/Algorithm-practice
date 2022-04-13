package boj;

import java.util.Scanner;

//¹æ ¹øÈ£
public class b_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		char[] room = input.toCharArray();
		int[] num = new int[10];	//0~9
		
		for(int i = 0; i < room.length; i++) {
			int temp = room[i] - '0';
			if(temp == 9)
				num[6]++;
			else
				num[temp]++;
		}

		num[6] = num[6] % 2 == 0? num[6]/2 :  num[6]/2+1;
		int max = 0;
		for(int i = 0; i < num.length; i++) {
			if(num[i] > max)
				max = num[i];
		}
		
		System.out.println(max);
		sc.close();
	}

}

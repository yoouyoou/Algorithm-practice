package study;

import java.util.Scanner;

public class b_2138 {

	static int[] bulb1, bulb2, make;
	static int N, ans = 0, temp1 = 0, temp2 = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		bulb1 = new int[N];
		bulb2 = new int[N];
		make = new int[N];
		
		String str1 = sc.next();
		String str2 = sc.next();
		
		String[] str = str1.split("");
		for(int i = 0; i < N; i++) {
			bulb1[i] = Integer.parseInt(str[i]);
			bulb2[i] = Integer.parseInt(str[i]);
		}
		
		str = str2.split("");
		for(int i = 0; i < N; i++)
			make[i] = Integer.parseInt(str[i]);
		
		if(!str1.equals(str2)) {
			Bulb1();		
			Bulb2();
			
			if(temp1 == -1 && temp2 == -1)
				ans = -1;
			else
				ans = temp1 == -1 ? temp2 : temp1;
		}
		
		System.out.println("\nans:" +ans);
		sc.close();
	}
	
	public static void Bulb1() {
		for(int i = 0; i < N; i++) {
			if(i == 0) {
				switching(0, bulb1);
				temp1++;
			}
			else if(i == N-1) {
				if(bulb1[i] != make[i] && bulb1[i-1] != make[i-1]) {
					switching(i, bulb1);
					temp1++;
				}
			}
			else {
				if(bulb1[i-1] != make[i-1]) {	//뒤가 다르다면 무조건 스위칭ㅇ
					switching(i, bulb1);
					temp1++;
				}
			}
		}
		
		System.out.println("bulb1 출력");
		for(int i = 0; i < N; i++) {
			System.out.print(bulb1[i] + " ");
			if(bulb1[i] != make[i]) {
				temp1 = -1;
				break;
			}
		}
	}
	
	public static void Bulb2() {
		for(int i = 0; i < N; i++) {
			if(i == 0)
				continue;
			else if(i == N-1) {
				if(bulb2[i] != make[i] && bulb2[i-1] != make[i-1]) {
					switching(i, bulb2);
					temp2++;
				}
			}
			else {
				if(bulb2[i-1] != make[i-1]) {	//뒤가 다르다면 무조건 스위칭ㅇ
					switching(i, bulb2);
					temp2++;
				}
			}
		}
		
		System.out.println("\nbulb2 출력");
		for(int i = 0; i < N; i++) {
			System.out.print(bulb2[i] + " ");
			if(bulb2[i] != make[i]) {
				temp2 = -1;
				break;
			}
		}
	}
	
	public static void switching(int x, int[] bulb) {
		if(x == 0) {
			bulb[x] = bulb[x] == 0 ? 1 : 0;
			bulb[x+1] = bulb[x+1] == 0 ? 1 : 0;
		}
		else if(x == N-1){
			bulb[x] = bulb[x] == 0 ? 1 : 0;
			bulb[x-1] = bulb[x-1] == 0 ? 1 : 0;
		}
		else {
			bulb[x-1] = bulb[x-1] == 0 ? 1 : 0;
			bulb[x] = bulb[x] == 0 ? 1 : 0;
			bulb[x+1] = bulb[x+1] == 0 ? 1 : 0;
		}
	}

}

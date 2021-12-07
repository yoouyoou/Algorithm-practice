package b_1644;

import java.util.ArrayList;
import java.util.Scanner;

//소수의 연속합 (골드3)
public class b_1644 {

	static boolean prime[];
	static ArrayList<Integer> primes = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0, sum = 0;
		
		prime = new boolean[n+1];
		// 소수배열 생성
		createPrime(n);
		for(int i = 0; i < primes.size(); i++)
			System.out.print(primes.get(i)+" ");
		
		// 확인
		/*
		int s = 0, e = 0;
		while(true) {
			if(sum >= n)
				sum -= primes.get(s++);
			else if(e == primes.size())
				break;
			else
				sum += primes.get(e++);
			if(n == sum)
				answer++;
		}
		*/
		
		
		for(int i = 0; i < primes.size(); i++) {
			for(int j = i; j < primes.size(); j++) {
				sum += primes.get(j);
				if(sum == n) {
					answer++;
					break;
				}
			}
			sum = 0;
		}
	
		
		System.out.println(answer);
		sc.close();
	}
	
	static void createPrime(int N) {
		prime[0] = prime[1] = true;
		for(int i = 2; i*i <= N; i++)
			if(!prime[i])
				for(int j=i*i; j <= N; j += i)
					prime[j] = true;
		for(int i = 1; i <= N; i++)
			if(!prime[i])
				primes.add(i);
		
		
		/* 노가다
		boolean check = true;
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					check = false;
					break;
				}
			}
			if(check)
				primes.add(i);
			else
				check = true;
		}
		*/
	}

}

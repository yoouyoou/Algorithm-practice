package boj;

import java.util.ArrayList;
import java.util.Scanner;

//요세푸스 문제
public class b_1158 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//인원
		int K = sc.nextInt();	//제거 순서
		int[] answer = new int[N];
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++)
			list.add(i);
		
		int cnt = 0, idx = 0, temp = 0;
		while(!list.isEmpty()) {
			
			cnt++;
			/*확인 출력
			System.out.print(cnt + "번째: ");
			for(int k: list)
				System.out.print(k + " ");
			System.out.println();
			System.out.println("---------------------------");
			확인 끝*/
			
			if(cnt == K) {
				//System.out.println("제거! idx: " + idx);
				answer[temp++] = list.get(idx);
				list.remove(idx);
				cnt = 0;
				if(idx > list.size()-1)	//idx가 list의 마지막을 지울 경우 처리
					idx = 0;
				continue;
			}
			idx++;
			if(idx > list.size()-1)
				idx = 0;
		}

		System.out.print("<");
		for(int i = 0; i < N; i++)
			if(i == N-1)
				System.out.print(answer[i] + ">");
			else
				System.out.print(answer[i] + ", ");
		
		sc.close();
	}

}

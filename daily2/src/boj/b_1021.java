package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//회전하는 큐
public class b_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer = 0;
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);	//수열 개수
		int M = Integer.parseInt(str[1]);	//개수
		str = br.readLine().split(" ");
		
		int[] m = new int[M];
		for(int i = 0; i < M; i++) 
			m[i] = Integer.parseInt(str[i]);
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1; i <= N; i++)
			list.add(i);
		
		for(int i = 0; i < M; i++) {
			int curIdx = list.indexOf(m[i]);	//객체가 저장된 인덱스값 반환
			//curIdx:왼쪽 개수, list.size()-curIdx:본인포함 오른쪽 개수
			if(curIdx < list.size() - curIdx) {		//왼쪽 개수가 더 적을때 (→이동)
				while(m[i] != list.getFirst()) 	//첫번째 요소 반환
					list.add(list.poll());
				answer += curIdx;
			}
			else {
				while(m[i] != list.peekLast())
					list.addFirst(list.pollLast());
				list.addFirst(list.pollLast());
				answer += list.size() - curIdx;
			}
			
			list.remove();	//첫번째 요소 제거
		}

		System.out.println(answer);
	}

}

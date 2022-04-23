package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//대표 선수
public class b_2461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);	//학급수
		int M = Integer.parseInt(str[1]);	//학급인원
		Student[] total = new Student[N * M];
		int idx = 0, answer = Integer.MAX_VALUE;
		
		//input
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++)
				total[idx++] = new Student(Integer.parseInt(str[j]), i);
		}
		
		int[] count = new int[N];
		Arrays.sort(total);
		
		idx = 0;
		int idx2 = 0, cnt = 0;
		while(idx2 < N * M) {
			if(count[total[idx2].cls] == 0)
				cnt++;
			count[total[idx2].cls]++;
			idx2++;
			
			while(cnt == N) {
				answer = Math.min(answer, total[idx2-1].ability - total[idx].ability);
				count[total[idx].cls]--;
				if(count[total[idx].cls] == 0)
					cnt--;
				idx++;
			}
		}
		
		/*
		visited[total[0].cls] = true;	//첫번째 학급 방문표시
		idx = 0;
		int idx2 = 1, cnt = 1;
		
		while(idx2 < N*M) {
			
			if(visited[total[idx2].cls] == false) {
				visited[total[idx2].cls] = true;
				cnt++;
			}
			idx2++;
			
			if(cnt == N) {
				answer = Math.min(answer, total[idx2-1].ability - total[idx].ability);
				visited = new boolean[N];
				if(idx2 == N*M)
					break;
				idx++;
				idx2 = idx + 1;
				cnt = 1;
				visited[total[idx].cls] = true;
			}
		}
		*/
		
		System.out.println(answer);
	}

}

class Student implements Comparable<Student>{
	int ability, cls;
	
	public Student(int ability, int cls) {
		this.ability = ability;
		this.cls = cls;
	}

	@Override
	public int compareTo(Student o) {
		return this.ability - o.ability;
//		if(this.ability < o.ability)
//			return -1;
//		return 0;
	}
}

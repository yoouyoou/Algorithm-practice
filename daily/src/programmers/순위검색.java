package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 순위검색 {

	static ArrayList<Applicant> list = new ArrayList<>();
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50" };
		
		String[] query = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150" };
		
		for(int a: solution(info, query))
			System.out.print(a + " ");
	}
	
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
//		char[] temp = new char[4];
		int idx = 0;
		String[] str;
		
		//info쪼개서 넣기
		for(String i: info) {
			char[] temp = new char[4];
			str = i.split(" ");
			
			for(int j = 0; j < 4; j++)
				temp[j] = str[j].charAt(0);
			
			list.add(new Applicant(temp, Integer.parseInt(str[4])));
		}

		Collections.sort(list);	//점수로 오름차순
		
//		for(Applicant l: list)
//			System.out.print(l.test +" ");
//		System.out.println();
		
		//query쪼개기
		for(String q: query) {
			char[] temp = new char[4];
			str = q.split(" and ");
			
			for(int j = 0; j < 3; j++) 
				temp[j] = str[j].charAt(0);
			
			str = str[3].split(" ");
			temp[3] = str[0].charAt(0);
			int score = Integer.parseInt(str[1]);
		
			answer[idx++] = count(temp, score);
		}
		
		return answer;
	}
	
	public static int count(char[] condition, int test) {
		int ans = 0, t;
		boolean flag;
		
		for(int i = 0; i < list.size(); i++) {
			
			if(list.get(i).test < test)
				continue;
			
			flag = true;
			t = 0;
			
			f1:
			for(char c: list.get(i).arr) {
				if(condition[t] == '-') {
					t++;
					continue;
				}
				
				if(c != condition[t++]) {
					flag = false;
					break f1;
				}
				
			}
			
			if(flag) {
				ans++;
				flag = true;
			}
		}
		
		return ans;
	}

}

class Applicant implements Comparable<Applicant>{
	char[] arr = new char[4];
	int test;
	
	Applicant(char[] arr, int test) {
		this.arr = arr;
		this.test = test;
	}

	@Override
	public int compareTo(Applicant arg0) {
		if(arg0.test > this.test)
			return -1;
		else
			return 1;
	}

	
}

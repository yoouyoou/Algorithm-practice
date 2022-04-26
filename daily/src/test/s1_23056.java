package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//참가자 명단
public class s1_23056 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);	//학급수
		int M = Integer.parseInt(str[1]);	//학급당 신청 가능한 인원수
		ArrayList<Student> stuList = new ArrayList<>();
		int[] limit = new int[N+1];
		
		//input
		while(true) {
			str = br.readLine().split(" ");
			
			if(str[0].equals("0") && str[1].equals("0"))
				break;
			
			int n = Integer.parseInt(str[0]);
			String name = str[1];
			
			limit[n]++;
			if(limit[n] > M)
				continue;
			
			stuList.add(new Student(n, name, name.length()));
		}
		
		Collections.sort(stuList);
		
		//홀수 학급 먼저 처리
		for(int i = 0; i < stuList.size(); i++) {
			if(stuList.get(i).n % 2 != 0) {	//홀수임
				System.out.println(stuList.get(i).n + " " + stuList.get(i).name);
			}
		}
		
		//짝수 학급 처리
		for(int i = 0; i < stuList.size(); i++) {
			if(stuList.get(i).n % 2 == 0) {	//홀수임
				System.out.println(stuList.get(i).n + " " + stuList.get(i).name);
			}
		}
		/* 
			1. 홀수반
			-> 오름차순, 학생의 이름의 길이가 짧은 것 부터, 길이가 같다면 사전순
			2. 짝수반
		 */
	}

}

class Student implements Comparable<Student>{
	int n;
	String name;
	int nameLen;
	
	public Student(int n, String name, int nameLen) {
		this.n = n;
		this.name = name;
		this.nameLen = nameLen;
	}
	
	@Override
	public int compareTo(Student arg0) {
		if(this.n > arg0.n)
			return 1;
		else if(this.n == arg0.n) {
			if(this.nameLen > arg0.nameLen)
				return 1;
			else if(this.nameLen == arg0.nameLen) {
				if(this.name.compareTo(arg0.name) > 0)
					return 1;
			}
		}
		return -1;
		
//		return this.n - arg0.n;
	}
}

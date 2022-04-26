package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//������ ���
public class s1_23056 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);	//�б޼�
		int M = Integer.parseInt(str[1]);	//�б޴� ��û ������ �ο���
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
		
		//Ȧ�� �б� ���� ó��
		for(int i = 0; i < stuList.size(); i++) {
			if(stuList.get(i).n % 2 != 0) {	//Ȧ����
				System.out.println(stuList.get(i).n + " " + stuList.get(i).name);
			}
		}
		
		//¦�� �б� ó��
		for(int i = 0; i < stuList.size(); i++) {
			if(stuList.get(i).n % 2 == 0) {	//Ȧ����
				System.out.println(stuList.get(i).n + " " + stuList.get(i).name);
			}
		}
		/* 
			1. Ȧ����
			-> ��������, �л��� �̸��� ���̰� ª�� �� ����, ���̰� ���ٸ� ������
			2. ¦����
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

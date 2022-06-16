package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//���� �ڸ���
public class b_14247 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Tree> list = new ArrayList<>();
		int answer = 0;
		int n = sc.nextInt();	//���� ����
		int[] H = new int[n];	//���� ���� ����
		int[] A = new int[n];	//�ڶ�� ����
		
		for(int i = 0; i < n; i++)
			H[i] = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
			list.add(new Tree(H[i], A[i]));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < n; i++) {
			System.out.println(list.get(i).len + ", " + list.get(i).growth);
			answer += list.get(i).len + (list.get(i).growth * i);
		}
		
		System.out.println(answer);
		sc.close();
	}

}

class Tree implements Comparable<Tree>{
	int len, growth;
	
	public Tree(int len, int growth) {
		this.len = len;
		this.growth = growth;
	}

	@Override
	public int compareTo(Tree arg0) {
		if(this.growth > arg0.growth)
			return 1;
		else if(this.growth == arg0.growth) {
			if(this.len > arg0.len)
				return 1;
			else
				return -1;
		}
		else
			return -1;
	}
}

package boj;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

//Á¦·Î
public class b_10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		int answer = 0;
		int k = sc.nextInt();
		
		for(int i = 0; i < k; i++) {
			int temp = sc.nextInt();
			
			if(temp == 0)
				st.pop();
			else
				st.push(temp);
		}
		
		Iterator<Integer> itr = st.iterator();
		while(itr.hasNext()) 
			answer += itr.next();
		
		System.out.println(answer);
		sc.close();
	}

}

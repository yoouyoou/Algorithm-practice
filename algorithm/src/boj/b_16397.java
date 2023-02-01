package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_16397 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = -1;
		int N = sc.nextInt();
		int T = sc.nextInt();
		int G = sc.nextInt();
		
		Queue<Pair> q = new LinkedList<Pair>();
		boolean[] visited = new boolean[100000];
		q.add(new Pair(N, 0));
		visited[N] = true;
		
		while(!q.isEmpty()) {
			Pair cur = q.poll();
			
			System.out.println("<cur: " + cur.num + ">");
			
			if(cur.num == G) {
				ans = cur.count;
				break;
			}
			
			if(cur.count + 1 > T)
				continue;
			
			//A버튼 클릭시 
			int n = cur.num + 1;
			if(n < 100000 && !visited[n]) {
				q.add(new Pair(n, cur.count + 1));
				visited[n] = true;
				System.out.println(n + "넣음");
			}
			
			//B버튼 클릭시
			n = cur.num * 2;
			if(n < 100000) {
				n = Btn(n);
				if(!visited[n]) {
					q.add(new Pair(n, cur.count + 1));
					visited[n] = true;
					System.out.println(n + "넣음");
				}
			}
		}
		
		System.out.println(ans != -1 ? ans : "ANG");
		sc.close();
	}
    
	public static int Btn(int n) {
		String str = Integer.toString(n);
		char[] arr = str.toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != '0') {
				int temp = (arr[i] - '0') - 1;
				arr[i] = (char) (temp + '0');
				break;
			}
		}
		
		str = "";
		for(char c: arr)
			str += c;

		return Integer.parseInt(str);
	}

}

class Pair{
	int num;
	int count;
	
	public Pair(int n, int c) {
		num = n;
		count = c;
	}
}

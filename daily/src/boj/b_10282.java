package boj;

import java.util.ArrayList;
import java.util.Scanner;

//��ŷ
public class b_10282 {

	static int n, d, c;
	static ArrayList<ArrayList<Node>> list;
	static int[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		for(int i = 0; i < testcase; i++) {
			n = sc.nextInt();	//��ǻ�� ����
			d = sc.nextInt();	//������ ����
			c = sc.nextInt();	//��ŷ ��ǻ�� ����
			
			list = new ArrayList<>();
			
			for(int j = 0; j <= n; j++)	//��ǻ�� ������ŭ
				list.add(new ArrayList<>());
			
			for(int j = 0; j < d; j++) {	//������ ������ŭ
				int a = sc.nextInt();
				int b = sc.nextInt();
				int s = sc.nextInt();
				list.get(b).add(new Node(a, s));
			}
			//printList();
			visited = new int[n+1];	//��ǻ�� ����
			dfs(c);
			
			int ans = 0, num = 0;
			for(int k = 1; k <= n; k++) {
				if(visited[k] > 0) {
					ans += visited[k];
					num++;
				}
			}
			
			System.out.println(num+1 + " " + ans);
		}
	}
	
	public static void dfs(int x) {
		for(int i = 0; i < list.get(x).size(); i++) {	//��ŷ���� �����ĵ�
			Node n = list.get(x).get(i);
			
			if(visited[n.idx] == 0 || visited[n.idx] > n.second) {
				visited[n.idx] = n.second;
				dfs(n.idx);
			}
		}
		return;
	}
	
	public static void printList() {
		for(int i = 1; i <= list.size(); i++) {
			for(int j = 0; j < list.get(i).size(); j++)
				System.out.print(list.get(i).get(j) + " ");
			System.out.println();
		}
	}

}

class Node{
	int idx, second;
	
	public Node(int idx, int second) {
		this.idx = idx;
		this.second = second;
	}
}

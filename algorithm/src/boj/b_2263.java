package boj;

import java.util.Scanner;

//트리의 순회
public class b_2263 {

	static int[] inorder, postorder, preorder;
	static int idx = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		inorder = new int[n];	//중위순회
		postorder = new int[n];	//후위순회
		preorder = new int[n];	//전위순회
		
		for(int i = 0; i < n; i++)
			inorder[i] = sc.nextInt();
		
		for(int i = 0; i < n; i++)
			postorder[i] = sc.nextInt();
		
		travelSubTree(0, n-1, 0, n-1);
		
		for(int a: preorder)
			System.out.print(a + " ");
		sc.close();
	}
	
	public static void travelSubTree(int is, int ie, int ps, int pe) {
		//if(ie < is || pe < ps) return;
		if(is <= ie && ps <= pe) {
			int root = postorder[pe];	//후위순회의 마지막이 루트노드
			preorder[idx++] = root;
			
			int rootIdx = 0;	//루트노드까지의 왼쪽 서브트리 개수
			for(int i = is; i <= ie; i++) {
				if(inorder[i] == root) { 	//중위순회에서 루트 발견시
					rootIdx = i;
					break;
				}
			}
			
			//왼쪽 서브트리 순회
			travelSubTree(is, rootIdx-1, ps, ps + rootIdx - is - 1);	//rootIdx - is: 왼쪽 서브트리 개수
			
			//오른쪽 서브트리 순회
			travelSubTree(rootIdx+1, ie, ps + rootIdx-is, pe-1);
		}
		
	}

}

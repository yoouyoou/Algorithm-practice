package boj;

import java.util.Scanner;

//Ʈ���� ��ȸ
public class b_2263 {

	static int[] inorder, postorder, preorder;
	static int idx = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		inorder = new int[n];	//������ȸ
		postorder = new int[n];	//������ȸ
		preorder = new int[n];	//������ȸ
		
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
			int root = postorder[pe];	//������ȸ�� �������� ��Ʈ���
			preorder[idx++] = root;
			
			int rootIdx = 0;	//��Ʈ�������� ���� ����Ʈ�� ����
			for(int i = is; i <= ie; i++) {
				if(inorder[i] == root) { 	//������ȸ���� ��Ʈ �߽߰�
					rootIdx = i;
					break;
				}
			}
			
			//���� ����Ʈ�� ��ȸ
			travelSubTree(is, rootIdx-1, ps, ps + rootIdx - is - 1);	//rootIdx - is: ���� ����Ʈ�� ����
			
			//������ ����Ʈ�� ��ȸ
			travelSubTree(rootIdx+1, ie, ps + rootIdx-is, pe-1);
		}
		
	}

}

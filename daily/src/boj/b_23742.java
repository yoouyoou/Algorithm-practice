package boj;

import java.util.Arrays;
import java.util.Scanner;

//Player-based Team Distribution
public class b_23742 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] parr = new long[N]; 		  //��� �ִ� �迭
		long[] narr = new long[N]; 		  //���� �ִ� �迭
		int pidx = 0, nidx = 0, pCnt;	  //�� �迭 �ε���, ����迭 ���� ī��Ʈ ����	
		long ans = 0, nsum = 0, psum = 0; 			  //�÷��̾� ������, ���� ����, ��� ����
		
		//input
		for(int i = 0; i < N; i++) {
			int t = sc.nextInt();
			if(t < 0) {
				narr[nidx++] = t;
				nsum += t;
			}
			else {
				parr[pidx++] = t;
				psum += t;
			}
		}
		
		//�ʱ� ������ ���ϱ�
		ans = (psum * pidx) + nsum;
		
		Arrays.sort(narr, 0, nidx);		//�����迭 ����ִ� ��ŭ ����
		
		//������ �����ϱ�
		pCnt = pidx;	//����迭 �Ѱ���
		for(int i = nidx-1; i >= 0; i--) {	//������ �ϳ��� ��������� �ѱ�
			pCnt++;
			nsum -= narr[i];				//���� ������ �� : ���߿� ���տ��� �� ��
			psum += narr[i];
			
			ans = Math.max(ans, psum * pCnt + nsum);
		}
		
		System.out.println(ans);
		sc.close();
	}

}

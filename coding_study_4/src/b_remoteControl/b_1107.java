package b_remoteControl;

import java.util.ArrayList;
import java.util.Scanner;

public class b_1107 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int aNum = 0;
		int channel = sc.nextInt();			// �̵��ϰ��� �ϴ� ä��
		int btnNum = sc.nextInt();			// ���峭 ��ư ����
		
		int a = channel;
		while(a != 0) {			// ����ä�� �ڸ��� ���ϱ�
			a /= 10;
			aNum++;
		}
		
		// ���峭 ��ư�� ���� ��
		if(btnNum == 0) {
			if(channel == 100) {			// ä���� 100�̸� ��ư �����ʿ����
				System.out.println("0");
				return;
			}
			if(aNum < Math.abs(channel-100)) {		// +,-��ư���� ���ڹ�ư �����°� �� ���� ���
				System.out.println(aNum);			// ����ä�� �ڸ��� ���
				return;
			}else {									
				System.out.println(Math.abs(channel)-100);	// ���Ʒ���ư Ƚ�� ���
				return;
			}
		} 
		// ��ư�� ��� ���峵�� ��
		else if(btnNum == 10) {
			System.out.println(Math.abs(channel)-100);
			return;
		}
		// ���峭 ��ư�� ���� ��
		else {
//			int[] btn = new int[btnNum];		// ���峭 ��ư �迭 �ޱ�
			ArrayList<Integer> btn = new ArrayList<>();
			for(int i = 0; i < btnNum; i++)
				btn.add(sc.nextInt());
//				btn[i] = sc.nextInt();
			
			if(channel == 100) {			// ä���� 100�̸� ��ư �����ʿ����
				System.out.println("0");
				return;
			}else {
				System.out.println(solution(channel, aNum, btn));
				return;
			}
		}
		
		/*
		if(channel == 100) {			// ä���� 100�̸� ��ư �����ʿ����
			System.out.println("0");
			return;
		}
		if(aNum < Math.abs(channel-100)) {		// +,-��ư���� ���ڹ�ư �����°� �� ���� ���
			System.out.println(aNum);			// ����ä�� �ڸ��� ���
			return;
		}else {									
			System.out.println(Math.abs(channel)-100);	// ���Ʒ���ư Ƚ�� ���
			return;
		}*/
		
	}
	
	public static int solution(int channel, int chSize, ArrayList<Integer> btnArr) {
		int ans = 0, temp = 0;
		int[] chArr = new int[chSize];	//����ä��
		int[] myArr = new int[chSize];	//�������� ä��
//		ArrayList<Integer> chArr = new ArrayList<Integer>();
		for(int i = chSize-1; i >= 0; i--) {
			chArr[i] = channel % 10;
//			chArr.add(i, channel % 10);
			channel /= 10;
		}
		
		for(int i = 1; i <= chSize; i++) {
			if(btnArr.contains( chArr[chSize-i]-temp) ) {
				temp = 0;
			}
			else {
				if(chArr[chSize] >= 5)
					temp++;
				else
					temp--;
			}
		}
		for(int i = 0; i < chSize; i++) {		// ä�� �ڸ�����ŭ �ݺ��� �����鼭
			
			if(btnArr.contains(chArr[i])) {		// �����ư ����O
				for(int j = 0; j < 10; j++) {
					if(j % 2 == 0)
					if(btnArr.contains(chArr[i]-temp)) {
						myArr[i] = chArr[i]-temp;
						break;
					}
				}
			}
			else 			
				ans++;		//�����Ʈ ����X
			
		}
		
		return -1;
	}

}

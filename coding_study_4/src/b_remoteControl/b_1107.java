package b_remoteControl;

import java.util.ArrayList;
import java.util.Scanner;

public class b_1107 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int aNum = 0;
		int channel = sc.nextInt();			// 이동하고자 하는 채널
		int btnNum = sc.nextInt();			// 고장난 버튼 개수
		
		int a = channel;
		while(a != 0) {			// 도착채널 자리수 구하기
			a /= 10;
			aNum++;
		}
		
		// 고장난 버튼이 없을 때
		if(btnNum == 0) {
			if(channel == 100) {			// 채널이 100이면 버튼 누를필요없음
				System.out.println("0");
				return;
			}
			if(aNum < Math.abs(channel-100)) {		// +,-버튼보다 숫자버튼 누르는게 더 빠를 경우
				System.out.println(aNum);			// 도착채널 자릿수 출력
				return;
			}else {									
				System.out.println(Math.abs(channel)-100);	// 위아래버튼 횟수 출력
				return;
			}
		} 
		// 버튼이 모두 고장났을 때
		else if(btnNum == 10) {
			System.out.println(Math.abs(channel)-100);
			return;
		}
		// 고장난 버튼이 있을 때
		else {
//			int[] btn = new int[btnNum];		// 고장난 버튼 배열 받기
			ArrayList<Integer> btn = new ArrayList<>();
			for(int i = 0; i < btnNum; i++)
				btn.add(sc.nextInt());
//				btn[i] = sc.nextInt();
			
			if(channel == 100) {			// 채널이 100이면 버튼 누를필요없음
				System.out.println("0");
				return;
			}else {
				System.out.println(solution(channel, aNum, btn));
				return;
			}
		}
		
		/*
		if(channel == 100) {			// 채널이 100이면 버튼 누를필요없음
			System.out.println("0");
			return;
		}
		if(aNum < Math.abs(channel-100)) {		// +,-버튼보다 숫자버튼 누르는게 더 빠를 경우
			System.out.println(aNum);			// 도착채널 자릿수 출력
			return;
		}else {									
			System.out.println(Math.abs(channel)-100);	// 위아래버튼 횟수 출력
			return;
		}*/
		
	}
	
	public static int solution(int channel, int chSize, ArrayList<Integer> btnArr) {
		int ans = 0, temp = 0;
		int[] chArr = new int[chSize];	//도착채널
		int[] myArr = new int[chSize];	//내가누른 채널
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
		for(int i = 0; i < chSize; i++) {		// 채널 자리수만큼 반복문 돌리면서
			
			if(btnArr.contains(chArr[i])) {		// 고장버튼 포함O
				for(int j = 0; j < 10; j++) {
					if(j % 2 == 0)
					if(btnArr.contains(chArr[i]-temp)) {
						myArr[i] = chArr[i]-temp;
						break;
					}
				}
			}
			else 			
				ans++;		//고장버트 포함X
			
		}
		
		return -1;
	}

}

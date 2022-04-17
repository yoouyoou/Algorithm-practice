package boj;

import java.util.Arrays;
import java.util.Scanner;

//Player-based Team Distribution
public class b_23742 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long[] parr = new long[N]; 		  //양수 넣는 배열
		long[] narr = new long[N]; 		  //음수 넣는 배열
		int pidx = 0, nidx = 0, pCnt;	  //각 배열 인덱스, 양수배열 개수 카운트 변수	
		long ans = 0, nsum = 0, psum = 0; 			  //플레이어 점수합, 음수 총합, 양수 총합
		
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
		
		//초기 점수합 구하기
		ans = (psum * pidx) + nsum;
		
		Arrays.sort(narr, 0, nidx);		//음수배열 들어있는 만큼 정렬
		
		//점수합 갱신하기
		pCnt = pidx;	//양수배열 총개수
		for(int i = nidx-1; i >= 0; i--) {	//음수를 하나씩 양수쪽으로 넘김
			pCnt++;
			nsum -= narr[i];				//개인 음수팀 합 : 나중에 총합에서 뺄 것
			psum += narr[i];
			
			ans = Math.max(ans, psum * pCnt + nsum);
		}
		
		System.out.println(ans);
		sc.close();
	}

}

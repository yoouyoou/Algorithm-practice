package test;
import java.util.*;

//에어컨
public class s2_25044 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;	//켜진 횟수
		ArrayList<Integer> list = new ArrayList<>();	//꺼진 시각의 분 넣어놀 리스트
		
		int[] increase = {180, 180, 1080};
		int N = sc.nextInt();	//날짜
		int K = sc.nextInt();	//지연되는 분
		int minute = 900;
		
		//모두 분으로 고쳐서 진행할 것 임
		//0일 째가 하루 끝이 1440분
		int Nstart = 1440 * N;	//N일째가 시작되는 누적 분 (하루 1440분 * 일수)
		int limit = Nstart + 1440;
		if(900 >= Nstart) {		//누적 900분으로 시작하기 때문에 0일째에 해당하는 거 따로 넣어줘야 함
			list.add(900);
			num++;
		}
		
		while(limit > minute) {
			for(int i = 0; i < 3; i++) {
				if(i == 2)
					minute += increase[i] + K;
				else
					minute += increase[i];
				
				if(limit <= minute)
					break;
				
				if(minute >= Nstart) {
					list.add(minute);
					num++;
				}
			}
		}
		
		System.out.println(num);
		for(int a: list) 
			System.out.println(String.format("%02d:%02d", (a/60)%24, a%60));
		
		sc.close();
	}
}
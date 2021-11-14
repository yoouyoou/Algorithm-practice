package b_stringExplosion;

import java.util.ArrayList;
import java.util.Collections;

public class b_9935 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		String exp_str = sc.next();
		String str = "12ab112ab2ab";
		String exp_str = "12ab";
		solution(str, exp_str);
	}
	
	public static void solution(String s1, String s2) {
		ArrayList<String> data = new ArrayList<String>();	
		int sIdx= -1, eIdx= -1, count = 0;
		
		String[] str = s1.split("");		
		String[] estr = s2.split("");
		Collections.addAll(data, str);		
		
		for(int i = 0; i < data.size(); i++) {

			if( data.get(i).equals(estr[0]) ) {	// 폭발문자열의 첫글자 발견
				System.out.println("폭발문자열 의심 감지!");
				sIdx = i;
				for(int j = sIdx; j < sIdx + estr.length; j++) { // 폭발문자열 의심구역부터 쭉 비교 while(count != estr.length) 
					if( !data.get(j).equals(estr[count++]) ) {	// 폭발문자열과 같지않으면
						System.out.println("아 아니였군");
						count = 0;
						break;
					}
					else						// 같으면 끝인덱스 갱신
						eIdx = j;
					System.out.println("폭발문자열 존재("+sIdx + ", " + eIdx + ")");
				}
				
				if(count == estr.length) {		// 폭발문자열 존재할 경우  if(check && sIdx != -1 && eIdx != -1)
					for(int j = sIdx; j <= eIdx; j++) {
						System.out.println("지울값: " + data.get(sIdx));
						data.remove(sIdx);
					}
					i = sIdx - estr.length;	// 확인위치에서 뒤에 문자열을 당겨왔으니까 폭발문자열개수만큼의 앞으로가서 당겨온 애가 앞에 애랑 합쳐서 또 폭발인지 확인
					if(i < 0)		// 근데 너무 초반에 발견되면 마이너스뜰수있는데 그때는 걍 처음부터 다시 보라고
						i = -1;		// -1인 이유는 이거나가면서 i의 증가가 수행되기 때문
					System.out.println("폭발문자열 존재할 경우의 변화된 i값: " + i);
				}
				count = 0;
			}
		}
			
		if(data.isEmpty())
			System.out.println("FRULA");
		else
			for(int i = 0; i < data.size(); i++)
				System.out.print(data.get(i));
	}

}


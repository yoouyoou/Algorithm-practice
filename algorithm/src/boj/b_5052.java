package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//전화번호 목록
public class b_5052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String[] phone = new String[n];
			
			for(int j = 0; j < n; j++)
				phone[j] = br.readLine();
			
//			양수-오름차순, 음수-내림차순, 0
//			Arrays.sort(phone,  new Comparator<String>() {
//				@Override
//				public int compare(String arg0, String arg1) {
//					return arg0.length() - arg1.length();
//				}
//			});
			
			solution(phone);
		}
	}
	
	public static void solution(String[] phone_book) {
        Arrays.sort(phone_book); 
        
        for (int i = 0; i < phone_book.length - 1; i++) 
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                System.out.println("NO");
                return;
            }
        
        System.out.println("YES");
        return;
	}

}

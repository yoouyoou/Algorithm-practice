package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1316 {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			if(check(str)) answer++;
		}

		System.out.println(answer);
	}
	
	public static boolean check(String str) {
		int[] ch = new int[26];
		boolean isFlag = false;
		
		ch[str.charAt(0) - 'a'] += 1;
		
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == str.charAt(i-1))
				isFlag = true;	//�̾����� ���ڿ���
			else
				isFlag = false;	//�޶��� ���ڿ�, ���� �갡 �ٽ� ������ �ȵ�
			
			if(!isFlag) {
				if(ch[str.charAt(i)-'a'] > 0)
					return false;
			}
			ch[str.charAt(i) - 'a'] += 1;
		}
		
		return true;
	}

}

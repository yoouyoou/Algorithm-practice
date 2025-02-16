package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1062 {

	static String[] words;
	static boolean[] alphabet;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);	// 단어개수
		int K = Integer.parseInt(input[1]);	// 배울 수 있는 글자 개수
		
		if(K < 5) {
			System.out.println(0);
			return;
		}else if(K == 26) {
			System.out.println(N);
			return;
		}
		
		words = new String[N];
		alphabet = new boolean[26];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			str = str.substring(4, str.length() - 4);
			words[i] = str;
		}
		
		// 배울 수 있는 글자 a, c, n, t, i
		alphabet['a' - 'a'] = true;
		alphabet['c' - 'a'] = true;
		alphabet['n' - 'a'] = true;
		alphabet['t' - 'a'] = true;
		alphabet['i' - 'a'] = true;
		K -= 5;
		
		DFS(0, 0, K);
		System.out.println(answer);
		return;
	}
	
	public static void DFS(int alpha, int count, int k) {
		//단어 다 배웠을 경우 카운트
		if(count == k) {
			int temp = 0;
			for(String word: words) {
				boolean flag = true;
				for(int j = 0; j < word.length(); j++) {
					if(!alphabet[word.charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if(flag)
					temp++;
			}
			answer = Math.max(answer, temp);
			return;
		}
		
		for(int i = alpha; i < 26; i++) {
			if(!alphabet[i]) {
				alphabet[i] = true;
				DFS(i + 1, count + 1, k);
				alphabet[i] = false;
			}	
		}
	}
}

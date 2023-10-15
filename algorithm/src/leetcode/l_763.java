package leetcode;

import java.util.ArrayList;
import java.util.List;

public class l_763 {

	public static void main(String[] args) {
		String s = "eccbbbbdec";
		String s1 = "ababcbacadefegdehijhklij";
		
		for(Integer i : partitionLabels(s1))
			System.out.print(i);
	}
	
	public static List<Integer> partitionLabels(String s) {
		List<Integer> answer = new ArrayList<>();
		int alphabet[] = new int[26];
		int lastIndex = 0, temp = 0;
		
		for(int i = 0; i < s.length(); i++)
			alphabet[s.charAt(i) - 'a'] = i;	//last index 집어넣기
		
		for(int i = 0; i < s.length(); i++) {
			lastIndex = Math.max(lastIndex, alphabet[s.charAt(i)-'a']);
			
			if(lastIndex == i) {	//현재까지 돌면서 포함되는 알파벳의 최대 파티션 인덱스까지 오게되었음
				answer.add(i- temp + 1);
				System.out.println(i + " - " + temp + " + 1");
				temp = i + 1;
			}
		}
		
		return answer;
    }

}

package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class l_1930 {

	public static void main(String[] args) {
		String s = "adc";
		System.out.println(countPalindromicSubsequence(s));
	}

	public static int countPalindromicSubsequence(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = s.length() - 1;
        
        while(end- start > 1) {
        	char cur = s.charAt(start);
        	
        	//key값 없는 경우
        	if(map.putIfAbsent(cur, 0) == null) {
        		Set<Character> set = new HashSet<>();
        		
        		//end를 줄여가며 start와 같은 글자를 찾음
        		while(start < end) {
        			if(cur == s.charAt(end)){
        				for(int i = start + 1; i < end; i++) 
        					set.add(s.charAt(i));
        				break;
        			}
        			end--;
        		}
        		map.put(cur, set.size());
        	}
        	
        	//key값 만들면 start 전진
        	start++;
        	end = s.length() - 1;
        }
        
        int answer = 0;
        for(int key : map.values())
        	answer += key;
        
        return answer;
    }
}

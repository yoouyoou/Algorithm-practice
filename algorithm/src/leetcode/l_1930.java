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
        	
        	//key�� ���� ���
        	if(map.putIfAbsent(cur, 0) == null) {
        		Set<Character> set = new HashSet<>();
        		
        		//end�� �ٿ����� start�� ���� ���ڸ� ã��
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
        	
        	//key�� ����� start ����
        	start++;
        	end = s.length() - 1;
        }
        
        int answer = 0;
        for(int key : map.values())
        	answer += key;
        
        return answer;
    }
}

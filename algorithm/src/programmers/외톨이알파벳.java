package programmers;

import java.util.HashSet;
import java.util.Set;

public class 외톨이알파벳 {

	public static void main(String[] args) {
		String test1 = "edeaaabbccd";
		String test2 = "eeddee";
		
		System.out.println(solution(test1));
	}
	
    public static String solution(String input_string) {
    	Set<Character> set = new HashSet<>();
//    	int[] alphabet = new int[26];
        int[] part = new int[26];
        char[] arr = input_string.toCharArray();
    	String answer = "";
        
        for(int i = 0; i < arr.length - 1; i++) {
        	System.out.println("** arr["+i+"] " + arr[i]);
        	int count = 0;
        	
        	for(int j = i+1; j < arr.length; j++) {
        		System.out.println("arr["+j+"] " + arr[j]);
        		if(arr[i] != arr[j]) {
        			char t = (char) (arr[i] - 49);
        			int temp = t - '0';
//        			System.out.println("temp: " + t);
        			if(count >= 2 && arr[temp] != -1) {
        				part[temp]++;
        				if(part[temp] >= 2) {
        					part[temp] = -1;
        					set.add(arr[i]);
        				}
        			}
        			
        			break;
        		}
        		count++;
        	}
        }
        
        System.out.println("Set!!!!!!!!!");
        for(char c: set)
        	System.out.print(c + ", ");
        
        return answer;
    }

}

package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class 숫자와영단어 {
	static String answer = "";
	static String temp;
	
	public static void main(String[] args) {
		String s = "23four5six7";
		int rslt = solution(s);
		System.out.println(rslt);
	}
	
	public static int solution(String s) {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "zero");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		
		String[] str = s.split("");
		temp = "";
		for(int i = 0; i < s.length(); i++) {
			if( Character.isDigit(s.charAt(i)) )	//숫자인 경우
					answer += str[i];
			else {
				temp += str[i];
				if(checkMap(map, temp))
					temp="";
			}
		}
		
		return Integer.parseInt(answer);
	}
	
	public static boolean checkMap(HashMap<Integer,String> map, String s) {
		Iterator<Integer> keys = map.keySet().iterator();
		while(keys.hasNext()) {
			int key = keys.next();
			if(map.get(key).equals(s)) {
				answer += String.valueOf(key);
				return true;
			}
		}
		return false;
	}

}

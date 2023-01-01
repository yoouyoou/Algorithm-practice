package test;

import java.util.Arrays;
import java.util.HashMap;

public class kakao_1 {

	public static void main(String[] args) {
		String t = "2023.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] p = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
		for(int a: solution(t, terms, p)) {
			System.out.print(a + " ");
		}

	}
	
    public static int[] solution(String today, String[] terms, String[] privacies) {
    	int[] temp = new int[privacies.length];
    	int idx = 0, count = 0;
    	
    	String[] st = today.split("\\.");
    	int cYear = Integer.parseInt(st[0]);
    	int cMonth = Integer.parseInt(st[1]);
    	int cDay = Integer.parseInt(st[2]);
    	System.out.println("현재: " + cYear +"."+cMonth+"."+cDay);
    	
    	HashMap<String, Integer> map = new HashMap<>();
    	
    	for(String t: terms) {
    		String[] str = t.split(" ");
    		map.put(str[0], Integer.parseInt(str[1]));
    	}
        
        for(String p: privacies) {
        	count++;
        	String[] str = p.split("\\.");
        	int year = Integer.parseInt(str[0]);
        	int month = Integer.parseInt(str[1]);
        	int day = Integer.parseInt(str[2].split(" ")[0]);
        	String type = str[2].split(" ")[1];
        	
            year += map.get(type) / 12;
            month += map.get(type) % 12;
            if(month > 12) {
        		year += 1;
        		month -= 12;
        	}
        	
        	System.out.println("폐기일: " + year +"."+month+"."+day);
        	
        	if(year < cYear) {
        		temp[idx++] = count;
        		System.out.println("년도 안됨");
        		continue;
        	}
        	
        	if(year == cYear && month < cMonth) {
        		temp[idx++] = count;
        		System.out.println("월이 더 작음");
        		continue;
        	}
        	
        	if(year == cYear && month == cMonth && day <= cDay) {
        		temp[idx++] = count;
        		System.out.println("3");
        		continue;
        	}
        	
        }
        
        int[] answer = new int[idx];
        for(int i = 0; i < idx; i++)
        	answer[i] = temp[i];
        Arrays.sort(answer);
        
        return answer;
    }

}

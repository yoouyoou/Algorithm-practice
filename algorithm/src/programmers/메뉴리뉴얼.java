package programmers;

import java.util.HashMap;

public class 메뉴리뉴얼 {
	
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};

		for(String s: solution(orders, course))
			System.out.print(s + " ");
	}

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        
        
        return answer;
    }
    
    public static void comb(String order, String others, int count) {
    	if(count == 0) {
    		map.put(order, map.getOrDefault(order, 0) + 1);
    		return;
    	}
    	
    	for(int i = 0; i < others.length(); i++)
    		comb(order + others.charAt(i), others.substring(i + 1), count - 1);
    }
}

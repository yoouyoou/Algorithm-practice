package programmers;

import java.util.HashMap;

public class ¿ß¿Â {

	public static void main(String[] args) {
		String[][] c = {
			{"yellow_hat", "headgear"}, 
			{"blue_sunglasses", "eyewear"}, 
			{"green_turban", "headgear"}
		};
		
		System.out.println(solution(c));
	}
	
    public static int solution(String[][] clothes) {
    	HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        
        for(String[] cloth : clothes) {
        	if(map.containsKey(cloth[1]))
        		map.put(cloth[1], map.get(cloth[1]) + 1);
        	else
        		map.put(cloth[1], 1);
        }
        
        for(String k : map.keySet())
        	answer *= map.get(k) + 1;
        
        return answer - 1;
    }

}

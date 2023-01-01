package programmers;

import java.util.HashMap;
import java.util.Iterator;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] p = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] c = {"josipa", "filipa", "marina", "nikola"};
		
		System.out.println(solution(p, c));
	}
	
	public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
		
		for(String p: participant){
            if(map.containsKey(p))
                map.put(p, map.get(p) + 1);
            else
                map.put(p, 1);
        }
		
		for(String c: completion)
			map.put(c, map.get(c) - 1);
		
		Iterator<String> keys = map.keySet().iterator();
		
		while(keys.hasNext()){
			String temp_k = keys.next();
			int temp_v = map.get(temp_k);
            
			if(temp_v != 0)
				return temp_k;
		}
		
		return "";
	}

}

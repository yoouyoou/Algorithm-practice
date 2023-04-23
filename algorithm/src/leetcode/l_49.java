package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l_49 {

	public static void main(String[] args) {
		String[] test = {"eat","tea","tan","ate","nat","bat"};
		String[] test2 = {"", ""};
		
		List<List<String>> list = groupAnagrams(test2);
		for(int i = 0; i < list.size(); i++) {
			ArrayList<String> temp = (ArrayList<String>) list.get(i);
			for(int j = 0; j < temp.size(); j++)
				System.out.print(temp.get(j) + " ");
			System.out.println();
		}
	}

    public static List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> answer = new ArrayList<>();
    	Map<String, String> map = new HashMap<>();
    	Map<String, List<String>> map2 = new HashMap<>();
    	ArrayList<String> emptyList = new ArrayList<>();
    	
    	for(String str: strs) {
    		if(str.equals("")) {
    			emptyList.add("");
    			continue;
    		}
    		char[] temp = str.toCharArray();
    		Arrays.sort(temp);
    		map.put(str, new String(temp));
    		System.out.println("map (" + str + ", " + map.get(str) + ")");
    	}
    	
    	for(String key: map.keySet()) {
    		String value = map.get(key);
    		
    		if(map2.containsKey(value))
    			map2.get(value).add(key);
    		else {
    			List<String> list = new ArrayList<>();
    			list.add(key);
    			map2.put(value, list);
    		}
    	}
    	
    	for(List value: map2.values())
    		answer.add(value);
    	
    	if(!emptyList.isEmpty())
    		answer.add(emptyList);
    	
    	return answer;
    }
}

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l_1002 {

	public static void main(String[] args) {
		String[] words = {"cool","lock","cook"};//{"bella","label","roller"};
		
		for(String s: commonChars(words)) {
			System.out.print(s + " ");
		}
	}

	public static List<String> commonChars(String[] words) {
        List<String> answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int[] abc = new int[26];
        String word = words[0];
        
        for(int i = 0; i < word.length(); i++)
        	if(map.containsKey(word.charAt(i)))
        		map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
        	else
        		map.put(word.charAt(i), 1);
        
        //2��°���� ����
        for(int i = 1; i < words.length; i++) {
        	word = words[i];
        	//�ش� �ܾ �� �ֵ� ����
        	for(int j = 0; j < word.length(); j++) 
        		abc[word.charAt(j) - 'a']++;
        		
        	//���� ù��° �ܾ�� �����鼭 �ڿ��� ���¾ֵ鸸 �� ���� ���ڷ� map������Ʈ
        	for(char key: map.keySet()) {
        		if(abc[key - 'a'] == 0)
        			map.put(key, 0);
        		else
        			map.put(key, Math.min(map.get(key), abc[key - 'a']));
        	}
        	//Arrays.fill(abc, 0);
        	for(int j = 0; j < word.length(); j++)
        		abc[word.charAt(j) - 'a'] = 0;
        }
        
        //map�� ���������� ���� �ֵ� list�� �ֱ�
        for(char key: map.keySet())
        	for(int i = 0; i < map.get(key); i++)
        		answer.add(String.valueOf(key));
        
        return answer;
    }
}

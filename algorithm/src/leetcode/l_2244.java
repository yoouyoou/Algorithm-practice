package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class l_2244 {

	public static void main(String[] args) {
		int[] test = {2,2,3,3,2,4,4,4,4,4};
		int[] test2 = {2,3,3};
		
		System.out.println(minimumRounds(test));
//		System.out.println(minimumRounds(test2));
	}
	
    public static int minimumRounds(int[] tasks) {
    	Arrays.sort(tasks);
    	int ans = -1;
    	HashMap<Integer, Integer> map = new HashMap<>();

    	/* ī��Ʈ 1�� */
    	int num, idx = 0;
    	while(idx < tasks.length) {
    		int count = 0;
    		num = tasks[idx];
    		
    		while(idx < tasks.length && num == tasks[idx]) {
    			idx++;
    			count++;
    		}
    		
    		System.out.println(count + "ó��");
    	}
    	
    	/* ī��Ʈ 2�� */
    	for(int t: tasks) {
    		if(!map.containsKey(t))
    			map.put(t, 1);
    		else {
    			map.put(t, map.get(t)+1);
    		}
    	}

    	for(int a: map.values())
    		System.out.print(a + ", ");
    	
    	return ans;
    }

}

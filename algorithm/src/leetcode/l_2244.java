package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class l_2244 {

	public static void main(String[] args) {
		int[] test = {2,2,3,3,2,4,4,4,4,4};
		int[] test2 = {69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69};
		
//		System.out.println(minimumRounds(test));
		System.out.println("\nans: " + minimumRounds(test2));
	}
	
    public static int minimumRounds(int[] tasks) {
//    	Arrays.sort(tasks);
    	int ans = 0;
    	HashMap<Integer, Integer> map = new HashMap<>();

    	/* 카운트 1안 */
//    	int num, idx = 0;
//    	while(idx < tasks.length) {
//    		int count = 0;
//    		num = tasks[idx];
//    		
//    		while(idx < tasks.length && num == tasks[idx]) {
//    			idx++;
//    			count++;
//    		}
//    		
//    		System.out.println(count + "처리");
//    	}
    	
    	/* 카운트 2안 */
    	for(int t: tasks) {
    		map.put(t, map.getOrDefault(t, 0) + 1);
    	}

    	for(int a: map.values()) {
    		if(a < 2)
    			return -1;
    		else if(a == 2)
    			ans += 1;
    		else
    			ans += Math.ceil((double)a / 3.0);
    		
    		/* 이럴 경우 8은 (2,2,2,2)로 나눠지게 되는데 (3,3,2)가 더 적합
    		System.out.print(a + "개: ");
            if(a % 7 == 0) {
                ans += (a / 7) * 3;
                System.out.println(7 + " ");
            }
            else if(a % 5 == 0) {
                ans += (a / 5) * 2 ;
                System.out.println(5 + " ");
            }
    		else if(a % 3 == 0) {
    			ans += a / 3;
    			System.out.println(3 + " ");
    		}
    		else if(a % 2 == 0) {
    			ans += a / 2;
    			System.out.println(2 + " ");
    		}
    		else
    			return -1;
    		 */
    	}
    	
    	return ans;
    }

}

package leetcode;

import java.util.Arrays;

public class l_2244 {

	public static void main(String[] args) {
		int[] test = {2,2,3,3,2,4,4,4,4,4};
		int[] test2 = {69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69};
		
		System.out.println(minimumRounds(test));
		System.out.println(minimumRounds(test2));
	}
	
    public static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int ans = 0;
 
    	int num, idx = 0;
   	    while(idx < tasks.length) {
   		    int count = 0;
   		    num = tasks[idx];
   		
   		    while(idx < tasks.length && num == tasks[idx]) {
   			    idx++;
   			    count++;
   		    }

            if(count < 2)
    			return -1;
    		else if(count == 2)
    			ans += 1;
    		else
    			ans += Math.ceil((double)count / 3.0);
   	    }
    	
    	return ans;
    }

}

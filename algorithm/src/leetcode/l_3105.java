package leetcode;

public class l_3105 {

	public static void main(String[] args) {
		int[] nums = {3,3,3,2};
		System.out.println(longestMonotonicSubarray(nums));
	}
	
	public static int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1) return 1;
		
        int answer = 0;
        int count = 1;
        int flag = 0;	//0:동일, 1:증가, 2:감소
        
        for(int i = 1; i < nums.length; i++){
            int diff = nums[i] - nums[i-1];
            
            if(i == 1) {
            	if(diff == 0) {
                	flag = 0;
                	count = 1;
            	}else if(diff > 0) {
            		flag = 1;
            		count = 2;
            	}else {
            		flag = 2;
            		count = 2;
            	}
            	continue;
            }
            
            if(diff == 0){
                if(flag != 0){
                    answer = Math.max(answer, count);
            	    count = 1;
            	    flag = 0;
                }
                else{
                    count = 1;
            	    flag = 0;
                }
            }
            
            if(diff > 0){
                if(flag == 1)
                    count++;
                else if(flag ==2){
                    answer = Math.max(answer, count);
            	    count = 2;
            	    flag = 1;
                }
                else if(flag ==0){
                    count++;
                    flag = 1;
                }
            }
            
            if(diff < 0){
                if(flag == 2)
                    count++;
                else if(flag == 1){
                    answer = Math.max(answer, count);
            	    count = 2;
            	    flag = 2;
                }
                else if(flag == 0){
                    count++;
                    flag = 2;
                }
            }
        }
        
        answer = Math.max(answer, count);
        return answer;
    }
	
}

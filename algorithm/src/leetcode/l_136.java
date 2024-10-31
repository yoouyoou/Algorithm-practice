package leetcode;

import java.util.Arrays;

public class l_136 {

	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println(singleNumber(nums));
		System.out.println(singleNumber2(nums));
	}
	
	//정렬 이용
	public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i+=2) {
        	if(i >= nums.length-1)
        		break;
        	
        	if(nums[i] != nums[i+1])
        		return nums[i];
        }
        
        return nums[nums.length-1];
    }
	
	//비트연산자 이용
	public static int singleNumber2(int[] nums) {
		int answer = 0;
		
		for(int num: nums)
			answer ^= num;
		
		return answer;
	}

}

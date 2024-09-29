package leetcode;

public class l_209 {

	public static void main(String[] args) {
		int[] nums = {12,28,83,4,25,26,25,2,25,25,25,12};
		int target = 213;
		
		System.out.println(minSubArrayLen(target, nums));
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
		int start = 0, end = 0, sum = 0;
		int answer = Integer.MAX_VALUE;
		
		while(end < nums.length) {
			sum += nums[end++];
			
			while(sum >= target) {
				answer = Math.min(answer, end - start);
				sum -= nums[start++];
			}
		}
		
		return answer == Integer.MAX_VALUE ? 0 : answer;
    }

}

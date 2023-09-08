package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class l_2616 {

	public static void main(String[] args) {
		int[] nums = {0,5,3,4};
		int p = 0;
		
		System.out.println(minimizeMax(nums, p));
	}
	
	public static int minimizeMax(int[] nums, int p) {
		int ans = 0;
		int low = 0;	//최소차
		int high = nums[nums.length-1] - nums[0];	//최대차
		
		Arrays.sort(nums);
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(isPossible(nums, p, mid)) {	//해당 mid가 최대차로 가능할 경우
				ans = mid;
				high = mid - 1;
			}
			else
				low = mid + 1;
		}
		
		return ans;
	}
	
	public static boolean isPossible(int[] nums, int p, int mid) {
		boolean flag = true;
		int count = 0;
		
		for(int i = 1; i < nums.length-1; i++) {
			if(!flag) {
				flag = true;
				continue;
			}
			
			if(nums[i] - nums[i-1] <= mid) {
				count++;
				flag = false;
			}
		}
		
		return count >= p;
	}

}

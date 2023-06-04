package leetcode;

import java.util.Arrays;

public class l_1775 {

	public static void main(String[] args) {
		int[] test1 = {1,2,3,4,5,6};
		int[] test2 = {1,1,2,2,2,2};
		System.out.println(minOperations(test1, test2));
		
		int[] test3 = {1,1,1,1,1,1,1};
		int[] test4 = {6};
		System.out.println(minOperations(test3, test4));
		
		int[] test5 = {6,6};
		int[] test6 = {1};
		System.out.println(minOperations(test5, test6));
		
		int[] test7 = {3,3,2,4,2,6,2};
		int[] test8 = {6,2,6,6,1,1,4,6,4,6,2,5,4,2,1};
		System.out.println(minOperations(test7, test8));
	}

    public static int minOperations(int[] nums1, int[] nums2) {
        int ans = 0, sum1 = 0, sum2 = 0;
        
        for(int n: nums1)	sum1 += n;
        for(int n: nums2)	sum2 += n;
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        if(sum1 == sum2)
        	return 0;
        
      //sum1합이 더 큼
        if(sum1 > sum2) {
        	int sidx = 0, eidx = nums1.length - 1;
        	int diff = sum1 - sum2;
        	
        	while(diff > 0) {
        		int temp1 = nums1[eidx] - 1;
        		int temp2 = 6 - nums2[sidx];
        			
        		if(temp1 == 0 && temp2 == 0)
        			return -1;
        		
            	if(temp1 >= temp2) {
            		diff -= temp1;
            		eidx--;
            		ans++;
            	}else {
            		diff -= temp2;
            		sidx++;
            		ans++;
            	}
            	
        		//한 배열이 전부 끝났을 경우 나머지 배열만 봐주기
        		if(sidx == nums2.length) {
        			while(eidx > -1 && diff > 0) {
        				diff -= nums1[eidx--] - 1;
        				ans++;
        			}
        			if(diff > 0) return -1;
        			else return ans;
        		}
        		
        		if(eidx == -1) {
        			while(sidx < nums1.length && diff > 0) {
        				diff -= 6 - nums2[sidx++];
        				ans++;
        			}
        			if(diff > 0) return -1;
        			else return ans;
        		}
        		//
        	}
        }
        //sum2합이 더 큼
        else {
        	int sidx = 0, eidx = nums2.length-1;
        	int diff = sum2 - sum1;
        	
        	while(diff > 0) {
        		int temp1 = nums2[eidx] - 1;
        		int temp2 = 6 - nums1[sidx];
        		
        		if(temp1 == 0 && temp2 == 0)
        			return -1;
        		
            	if(temp1 >= temp2) {
            		diff -= temp1;
            		eidx--;
            		ans++;
            	}else {
            		diff -= temp2;
            		sidx++;
            		ans++;
            	}
            	
        		//한 배열이 전부 끝났을 경우 나머지 배열만 봐주기
        		if(sidx == nums1.length) {
        			while(eidx > -1 && diff > 0) {
        				diff -= nums2[eidx--] - 1;
        				ans++;
        			}
        			if(diff > 0) return -1;
        			else return ans;
        		}
        		
        		if(eidx == -1) {
        			while(sidx < nums2.length && diff > 0) {
        				diff -= 6 - nums1[sidx++];
        				ans++;
        			}
        			if(diff > 0) return -1;
        			else return ans;
        		}
        		//
        	}
        }
        
        return ans;
    }
}

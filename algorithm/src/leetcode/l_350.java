package leetcode;

import java.util.HashMap;

public class l_350 {

	public static void main(String[] args) {
		int[] nums1 = {4,9,5};
		int[] nums2 = {9,4,9,8,4};

		for(int a: intersect(nums1, nums2))
			System.out.print(a + " ");
	}
	
    public static int[] intersect(int[] nums1, int[] nums2) {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	int[] temp = new int[Math.max(nums1.length, nums2.length)];
    	int idx = 0;
    	
    	
    	for(int n1: nums1) {
    		if(map.putIfAbsent(n1, 1) != null) {
    			map.put(n1, map.get(n1) + 1);
    		}
    	}
    	
    	for(int n2: nums2) {
    		if(map.containsKey(n2) && map.get(n2) > 0) {
    			temp[idx++] = n2;
    			map.put(n2, map.get(n2) - 1);
    		}
    	}
    	
    	int[] answer = new int[idx];
    	for(int i = 0; i < idx; i++)
    		answer[i] = temp[i];
    	
    	return answer;
    }

}

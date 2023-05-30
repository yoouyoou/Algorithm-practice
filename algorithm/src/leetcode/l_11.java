package leetcode;

public class l_11 {

	public static void main(String[] args) {
		int[] test = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(test));
		
		int[] test2 = {1, 1};
		System.out.println(maxArea(test2));
	}

    public static int maxArea(int[] height) {
        int sidx = 0, eidx = height.length-1;
        int width = eidx - sidx;
        int area = 0;
        
        while(sidx != eidx) {
        	area = Math.max(area, Math.min(height[sidx],height[eidx]) * width);
        	width--;
        	
        	if(height[sidx] <= height[eidx])
        		sidx++;
        	else
        		eidx--;
        }
        
        return area;
    }
}

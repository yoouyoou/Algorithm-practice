package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 입국심사 {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};
		
		System.out.println(solution(n, times));
	}

    public static long solution(int n, int[] times) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	Arrays.sort(times);
    	
    	for(int i = 0; i < n; i++) {
    		
    	}
    	
    	for(int i = 0; i < times.length; i++) {
    		for(int j = 1; j <= n; j++)
    			pq.add(times[i] * j);
    	}
    	
    	for(int i = 0; i < n-1; i++) {
    		System.out.println(pq.poll());
    	}
    	
        return pq.peek();
    }
    
}

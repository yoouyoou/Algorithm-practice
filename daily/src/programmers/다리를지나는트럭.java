package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		
		int ans = solution(bridge_length, weight, truck_weights);
		System.out.println(ans);
	}
	
	public static int solution(int length, int weight, int[] truck) {
		Queue<Integer> q = new LinkedList<Integer>();
		int answer = 0, count = 0;
		int qweight = 0, idx = 0;

		/*
		qweight += truck[idx];
		q.offer(truck[idx]);
		while(!q.isEmpty()) {
			
		}
		*/
		
		while(idx != truck.length) {
			
			for(int j = 0; j < length; j++) {	// 트럭이 올라가는 다리 개수
				System.out.println("트럭 인덱스: " + idx);
				if(idx == truck.length-1) {		// 트럭이 모두 다리에 진입
					if(qweight + truck[idx] > weight) {
						qweight -= q.poll();
						answer++;
						count++;
						continue;
					}
					answer += length-count;
					return answer;
				}
				qweight += truck[idx];
				if(qweight <= weight)
					q.offer(truck[idx++]);
				else
					qweight -= truck[idx];
				answer++;
				System.out.println(q);
			}
			qweight -= q.poll();
		}
		
		return answer;
	}

}

package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class �ٸ���������Ʈ�� {

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
			
			for(int j = 0; j < length; j++) {	// Ʈ���� �ö󰡴� �ٸ� ����
				System.out.println("Ʈ�� �ε���: " + idx);
				if(idx == truck.length-1) {		// Ʈ���� ��� �ٸ��� ����
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

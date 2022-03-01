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
		int answer = 0;
		int qweight = 0, idx = 0;

		while(idx < truck.length) {
			System.out.println("idx: " + idx);
			for(int j = 0; j < length; j++) {	// 트럭이 올라가는 다리 개수
				qweight += truck[idx];
				if(qweight <= weight)
					q.offer(truck[idx++]);
				else
					qweight -= truck[idx];
            
                if(idx == truck.length)
                    break;
				answer++;
			}
			qweight -= q.poll();
		}
        //마지막 트럭진입 후 idx가 트럭개수랑 같아져서 while문 빠져나옴
        answer += length;  //그래서 다리개수만큼 건너는거 도와줘야함
		return answer + 1;
	}

}

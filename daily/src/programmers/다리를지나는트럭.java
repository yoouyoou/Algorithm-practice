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
		int answer = 0;
		int qweight = 0, idx = 0;

		while(idx < truck.length) {
			System.out.println("idx: " + idx);
			for(int j = 0; j < length; j++) {	// Ʈ���� �ö󰡴� �ٸ� ����
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
        //������ Ʈ������ �� idx�� Ʈ�������� �������� while�� ��������
        answer += length;  //�׷��� �ٸ�������ŭ �ǳʴ°� ���������
		return answer + 1;
	}

}

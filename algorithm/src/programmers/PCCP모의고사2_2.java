package programmers;

import java.util.PriorityQueue;

public class PCCP모의고사2_2 {

	public static void main(String[] args) {
		int[] ability = {10, 3, 7, 2};
		int number = 2;
		System.out.println(solution(ability, number));
	}
	
	public static int solution(int[] ability, int number) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int ans = 0;
		
		for(int a : ability)
			pq.add(a);
		
		for(int i = 0; i < number; i++) {
			int sum = pq.poll();
			sum += pq.poll();
			pq.add(sum);
			pq.add(sum);
		}
		
		for(int i = 0; i < ability.length; i++)
			ans += pq.poll();

        return ans;
    }

}

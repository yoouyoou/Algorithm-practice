package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//보석도둑
public class b_1202 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		long answer = 0;
		int N = Integer.parseInt(str[0]);	//보석 개수
		int K = Integer.parseInt(str[1]);	//가방 개수
		
		//int[] M = new int[N];	//보석 무게
		//int[] V = new int[N];	//보석 가격
		int[] C = new int[K];	//가방 수용 무게
		Jewelry[] jews = new Jewelry[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());	//내림차순
		
		//보석 정보 입력
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			jews[i] = new Jewelry(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		
		//가방 정보 입력
		for(int i = 0; i < K; i++)
			C[i] = Integer.parseInt(br.readLine());

		Arrays.sort(C);		//가방은 오름차순 (가벼운 것부터)
		Arrays.sort(jews);	//보석 무게 오름차순 (가벼운 것부터)
		
		for(int i = 0, j = 0; i < K; i++) {	
			while(j < N && jews[j].weight <= C[i])
				pq.offer(jews[j++].price);
			
			if(!pq.isEmpty())
				answer += pq.poll();
		}
		
//		for(int i = 0; i < K; i++) {
//			if(pq.isEmpty())
//				break;
//			answer += pq.poll();
//		}
		
		
		System.out.println(answer);
	}

}

class Jewelry implements Comparable<Jewelry>{
	int weight, price;
	
	public Jewelry(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int compareTo(Jewelry arg0) {
		if(this.weight > arg0.weight)
			return 1;
		else
			return -1;
	}

}
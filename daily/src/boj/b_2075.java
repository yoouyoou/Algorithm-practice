package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//N번째 큰 수
public class b_2075 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				if(i == N-1)
					pq.add(new Pair(i, j, arr[i][j]));
			}
		}
		
		//일단 맨 밑에서 큰 것부터 꺼내오자
		int count = 0;
		while(true) {
			//System.out.println("현재 나온 값: " + pq.peek().num);
			if(count == N-1) {
				System.out.println(pq.poll().num);	//N번째 꺼내기
				break;
			}
			
			Pair cur = pq.poll();
			pq.add(new Pair(cur.r - 1, cur.c, arr[cur.r-1][cur.c]));
			count++;
		}

	}

}

class Pair implements Comparable<Pair>{
	int r, c, num;
	
	public Pair(int r, int c, int num) {
		this.r = r;
		this.c = c;
		this.num = num;
	}

	@Override
	public int compareTo(Pair arg0) {
		if(this.num > arg0.num)
			return -1;
		return 1;
	}
}

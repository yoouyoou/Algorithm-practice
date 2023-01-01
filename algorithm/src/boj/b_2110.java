package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//공유기 설치
public class b_2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int answer = 0;
		int N = Integer.parseInt(str[0]);	//집 개수
		int C = Integer.parseInt(str[1]);	//공유기 개수
		int[] arr = new int[N];				//집의 x좌표
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int start = 1;
		int end = arr[N-1] - arr[0];
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			int count = 1; 	//공유기 설치 개수
			int cur = arr[0];	//가장 첫번째 집 설치
			
			//해당 mid값이 가장 인접한 공유기의 값이 되는지 확인 -> 공유기 간 거리에서 mid가 최소가 되어야
			for(int i = 1; i < N; i++) {
				if(arr[i] - cur >= mid) {
					count++;
					cur = arr[i];
				}
			}
			
			if(count >= C) { //설치할 수 있으므로 공유기 거리를 더 넓히기
				start = mid + 1;
				answer = mid;
			}
			else	//mid값이 사이가 되도록 공유기 설치를 못하므로 거리를 줄여야 함
				end = mid - 1;
		}
		
		System.out.println(answer);
	}

}

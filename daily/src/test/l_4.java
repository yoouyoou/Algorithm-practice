package test;

public class l_4 {

	public static void main(String[] args) {
		//testcase1 -> 3
//		int[] arr = {3, 7, 2, 4};
//		int[] brr = {4, 5, 5, 2};
		
		//testcase2 -> 2
		int[] arr = {6, 2, 2, 6};
		int[] brr = {4, 4, 4, 4};
		
		System.out.println(solution(arr, brr));
	}
	
	public static int solution(int[] arr, int[] brr) {
		int answer = 0;
		
		for(int i = 0; i < arr.length-1; i++) {
			int diff = Math.abs(arr[i] - brr[i]);
			
			if(diff == 0) {
				continue;
			}
			
			//기존 배열이 만드려는 배열보다 크면 
			if(arr[i] > brr[i]) {
				arr[i] -= diff;
				arr[i+1] += diff;
			}
			else {
				arr[i] += diff;
				arr[i+1] -= diff;
			}
			
			answer++;
		}
		
		return answer;
	}

}

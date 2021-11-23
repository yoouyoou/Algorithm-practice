import java.util.Scanner;

public class Student20180983 {

	static int[][] button;
	static int[] bucket;
	static int[] bucket_count;
	static int[] arr = {0,1,2,3,4,5,6,7,8,9};
	static int answer = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Input data
		button = new int[10][5];
		for(int i = 0; i < 10; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			for(int j = 0; j < n2; j++)
				button[n1][j] = sc.nextInt();
		}
		
		int[] clocks = new int[16];
		for(int i = 0; i < 12; i++)
			clocks[i] = sc.nextInt();
		sc.close();		
		
		//Solution
		int max = 0;
		bucket = new int[16];
		bucket_count = new int[16];
		for(int i = 0; i < clocks.length; i++) {
			if(clocks[i] == 3)
				bucket[i] = 3;
			else if(clocks[i] == 6)
				bucket[i] = 2;
			else if(clocks[i] == 9)
				bucket[i] = 1;
			else
				bucket[i] = 0;
			
			if(max < bucket[i] && max != 3)
				max = bucket[i];	// 눌러야 할 최대버튼수
		}
		
		/*int[] arr = {0,1,2,3,4,5,6,7,8,9};
		boolean[] visited = new boolean[10];
		for(int i = 0; i < 10; i++)
			combination(arr, visited, 0, 10, max);*/
		int[] temp = new int[max];
		System.out.println("max값? :" + max);
		comb(max, temp, 0, 0);
		
		System.out.println(answer);
		return;
	}
	
	// 중복 조합
	static void comb(int r, int[] temp, int current, int start) {
		if(r == current) {				//r개 다 뽑았을 때
			for(int i = 0; i < temp.length; i++) {
				int k = temp[i];		// temp:뽑은 버튼 넣어놓은 배열
				if(button[k].length == 5) {
					for(int j = 0; j < 5; j++)
						bucket_count[button[k][j]]++; 
				}else {
					for(int j = 0; button[k][j] != 0; j++)
						bucket_count[button[k][j]]++; 
				}
			}
			int rslt = checkEqual_2(bucket, bucket_count);
			for(int i = 0; i < 16; i++)
				bucket_count[i] = 0;
			if(rslt == 1) {
				if(r < answer)
					answer = r;
			}
		}
		else {
			for(int i = start; i < arr.length; i++) {
				temp[current] = arr[i];
				comb(r, temp, current+1, i);
			}
		}
	}
	
	static int checkEqual_1(int[] arr, boolean[] visited, int n) {
		int k;
		for(int i = 0; i < n; i++) {
			if(visited[i]) {
				k = arr[i];
				if(button[k].length ==5) {
					for(int j = 0; j < 5; j++)
						bucket_count[button[k][j]]++; 
				}else {
					for(int j = 0; button[k][j] != 0; j++)
						bucket_count[button[k][j]]++; 
				}
			}
		}
		return checkEqual_2(bucket, bucket_count);
	}
	
	// 같음(1)이면 모두 정각 바라봄
	static int checkEqual_2(int[] bucket, int[] bucket_count) {
		for(int i = 0; i < 15; i++)
			if(bucket[i] != bucket_count[i])
				return -1;		//No equal
		return 1;				//equal
	}
	
	//조합
	static void combination(int[] arr, boolean[] visited, int depth, int n, int r) {
		if(r == 0) {
			int rslt = checkEqual_1(arr, visited, n);
			if(rslt == 1)
				if(r < answer)
					answer = r;
			return;
		}
		if(depth == n)
			return;
		
		visited[depth] = true;
		combination(arr, visited, depth+1, n, r-1);
		
		visited[depth] = false;
		combination(arr, visited, depth+1, n, r);
	}
	
}

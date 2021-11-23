package p_keypad;

import java.util.Scanner;

public class p_67256 {

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
			for(int j = n2; j < 5; j++)	//
				button[n1][j] = -1;		//
		}
		
		int[] clocks = new int[16];
		for(int i = 0; i < 16; i++)
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
		
		System.out.print("clock: ");
		for(int i = 0; i < 16; i++)
			System.out.print(clocks[i] + " ");
		System.out.print("\n bucket: ");
		for(int i = 0; i < 16; i++)
			System.out.print(bucket[i] + " ");
		System.out.println();
		
		
		System.out.println("max값? :" + max);
		int[] temp;
		for(int i = max; i > 0; i--) {
			temp = new int[max];
			comb(i, temp, 0, 0);
		}
		System.out.println(answer);
		return;
	}
	
	// 중복 조합
	static void comb(int r, int[] temp, int current, int start) {
		//r개 다 뽑았을 때
		if(r == current) {
			System.out.println("-------------------"+r+"개 최종 선택--------------------");
			for(int i = 0; i < temp.length; i++) {
				int k = temp[i];		// temp:뽑은 버튼 넣어놓은 배열
				for(int j = 0; button[k][j] != -1; j++) {
					bucket_count[button[k][j]]++;
					if(j == 4)
						break;
				}
			}
			int rslt = checkEqual(bucket, bucket_count);
			for(int i = 0; i < 16; i++)
				bucket_count[i] = 0;
			if(rslt == 1) {
				System.out.println("같아짐: " + r);
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
	
	// 1리턴이면 모두 정각 바라봄
	static int checkEqual(int[] bucket, int[] bucket_count) {
		System.out.println("\nbucket_count: ");
		for(int i = 0; i < 16; i++)
			System.out.print(bucket_count[i] + " ");
		
		for(int i = 0; i < 16; i++)
			if(bucket[i] != bucket_count[i])
				return -1;		//No equal
		return 1;				//equal
	}

}

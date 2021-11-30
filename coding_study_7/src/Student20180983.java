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
			for(int j = n2; j < 5; j++)
				button[n1][j] = -1;	
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
			
			if(bucket[i] > 0)
				max++;
		}
		
		
		int[] temp;
		for(int i = max; i > 0; i--) {
			temp = new int[i];
			comb(i, temp, 0, 0);
		}
		System.out.println(answer);
		return;
	}
	
	// repeat combination
	static void comb(int r, int[] temp, int current, int start) {
		if(r == current) {
			for(int i = 0; i < temp.length; i++) {
				int k = temp[i];
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
	
	static int checkEqual(int[] bucket, int[] bucket_count) {
		for(int i = 0; i < 16; i++)
			if(bucket[i] != bucket_count[i])
				return -1;		//No equal
		return 1;				//equal
	}
	
}

package b_permutation;

import java.util.Scanner;

//모든 순열 (실버3)
public class b_10974 {
	static int[] output;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		output = new int[N];
	}
	
	public static void permutation(int arr[], boolean[] visited, int N, int start, int depth) {
		output[depth] = start + 1;
		
	}
	
}

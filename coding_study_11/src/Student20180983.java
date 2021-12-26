import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Student20180983 {
	
	static int divide;
	static int[] bucket;
	static ArrayList<Integer> idxList;
	static int min = 900;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		divide = sc.nextInt();
		bucket = new int[num];
		idxList = new ArrayList<Integer>();
		boolean[] visited = new boolean[num];
		int[] arr = new int[num];

		for(int i = 0; i < num; i++) 
			bucket[i] = sc.nextInt();
		Arrays.sort(bucket);
		
		for(int i = 0; i < num; i++)
			arr[i] = i;
		
		combination(arr, visited, 0, num, divide-1);	
		System.out.println(min);
		sc.close();
	}
	
	// 분할 그룹 하나의 오차값 리턴
	public static int oneGroupError(ArrayList<Integer> arr) {
		int average = 0;
		int sum = 0;
		if(arr.size() == 0)
			return 0;
		for(int i = 0; i < arr.size(); i++) {
			average += arr.get(i);
		}
		average /= arr.size();
		
		for(int i = 0; i < arr.size(); i++) 
			sum += Math.pow((arr.get(i) - average), 2);
		
		return sum;
	}
	
	// 그룹의 전체 오차값 합 리턴 (정수가 아닐경우 판별해야함) 
	public static int groupError(ArrayList<Integer> arr) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int start_idx = 0;
		int end_idx, rslt = 0;
		
		while(arr.size() != 0) {
			end_idx = arr.get(0);
			arr.remove(0);
			for(int i = start_idx; i < end_idx; i++) {
				temp.add(bucket[i]);
				start_idx++;
			}
			rslt += oneGroupError(temp);
			temp.clear();
		}
		
		for(int i = start_idx; i < bucket.length; i++)
			temp.add(bucket[i]);
		rslt += oneGroupError(temp);
		
		return rslt; 
	}

	
	public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if(r == 0) {
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					//System.out.println(arr[i]);
					idxList.add(arr[i]);
				}
			}
			int temp = groupError(idxList);
			if(temp < min)
				min = temp;
			idxList.clear();
			return;
		}
		
		for(int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i+1, n, r-1);
			visited[i] = false;
		}
	}
	
}

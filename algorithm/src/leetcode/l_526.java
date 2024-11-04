package leetcode;

public class l_526 {

	static int answer;
	
	public static void main(String[] args) {
		System.out.println(countArrangement(2));
	}
	
	public static int countArrangement(int n) {
        answer = 0;
        int[] arr = new int[n];
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        
        for(int i = 1; i <= n; i++)
        	arr[i-1] = i;
        perm(arr, output, visited, 0, n);
        return answer;
    }
	
	public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n) {
		if(depth == n) {
			// 아름다운 배열인지 체크 output
			for(int i: output)
				System.out.print(i +" ");
			System.out.println();
			if(checkBeautifulArr(output)) answer++;
			return;
		}
		
		for(int i= 0; i < n; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n);
				visited[i] = false;
			}
		}
	}
	
	public static boolean checkBeautifulArr(int[] arr) {
		for(int i = 1; i <= arr.length; i++) {
			if(!(i % arr[i-1] == 0 || arr[i-1] % i == 0)) {
				return false;
			}
		}
		
		return true;
	}
}

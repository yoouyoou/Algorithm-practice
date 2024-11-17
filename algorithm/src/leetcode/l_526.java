package leetcode;

public class l_526 {

	static int answer;
	static boolean[] visited;
	
	public static void main(String[] args) {
		System.out.println(countArrangement(2));
	}
	
	public static int countArrangement(int n) {
		answer = 0;
		visited = new boolean[n+1];
        DFS(n, 1, new int[n+1]);
        return answer;
    }
	
	public static void DFS(int n, int depth, int[] perm) {
		if(depth == n+1) {
			answer++;
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				if(i % depth == 0 || depth % i == 0) {
					perm[depth] = i;
					visited[i] = true;
					DFS(n, depth+1, perm);
					visited[i] = false;
				}
			}
		}
	}
}

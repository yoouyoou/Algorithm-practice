package programmers;

public class ÇÇ·Îµµ {
	
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) {
		int k = 80;
		int[][] d = {{80, 20}, {50, 40}, {30, 10}};

		System.out.println(solution(k, d));
	}

    public static int solution(int k, int[][] dungeons) {
    	answer = 0;
    	visited = new boolean[dungeons.length];
    	
    	dfs(k, dungeons, 0, 0);
        
        return answer;
    }
    
    public static void dfs(int k, int[][] dungeons, int depth, int count) {
    	if(depth == dungeons.length) {
    		answer = answer > count ? answer : count;
    		return;
    	}
    	
    	for(int i = 0; i < dungeons.length; i++) {
    		if(dungeons[i][0] > k || visited[i])
    			continue;
    		
    		visited[i] = true;
    		dfs(k-dungeons[i][1], dungeons, depth+1, count+1);
    		visited[i] = false;
    	}
    	
    	dfs(k, dungeons, depth+1, count);
    }
}

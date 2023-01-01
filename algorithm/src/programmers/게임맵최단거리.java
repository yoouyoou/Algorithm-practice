package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		//0:벽 1:이동
		int[][] map = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
		};
		
		System.out.println(solution(map));
	}
	
    public static int solution(int[][] maps) {
    	int n = maps.length;
    	int m = maps[0].length;
    	visited = new boolean[n][m];
    	
//    	System.out.println("n: " + n + " m: " + m);
    	Queue<Node2> q = new LinkedList<Node2>();
    	q.add(new Node2(0, 0, 1));
    	visited[0][0] = true;
    	
    	while(!q.isEmpty()) {
    		Node2 cur = q.poll();
    		
    		for(int i = 0; i < 4; i++) {
    			int nr = cur.r + dr[i];
    			int nc = cur.c + dc[i];
    			
    			if(nr == n-1 && nc == m-1 && maps[nr][nc] == 1)
    				return cur.count + 1;
    			
        		if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
        			if(maps[nr][nc] == 1 && !visited[nr][nc]) {
//        				System.out.println("[" + nr + ", " + nc + "]");
        				q.add(new Node2(nr, nc, cur.count + 1));
        				visited[nr][nc] = true;
        			}
        		}
    		}
    		
    	}
    	
        return -1;
    }


}

class Node2{
	int r, c, count;
	
	public Node2(int r, int c, int count) {
		this.r = r;
		this.c = c;
		this.count = count;
	}
}

package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 석유시추 {

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] visited;
	static int[][] arr;
	static int n, m, total;
	
	public static void main(String[] args) {
		int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
		System.out.println(solution(land));
	}

	public static int solution(int[][] land) {
		HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        n = land.length;
        m = land[0].length;
        arr = land;
        visited = new int[n][m];
        
        int temp = 1;
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j < m; j++) {
        		if(land[i][j] == 1 && visited[i][j] == 0) {
        			total = 0;
        			DFS(i, j, temp);
            		map.put(temp, total);
            		temp++;
        		}
        	}
        }
        
        for(int i = 1; i <= map.size(); i++)
        	System.out.println("map[" + i + "] = " + map.get(i));
        
        for(int i = 0; i < m; i++) {
        	Set<Integer> set = new HashSet<>();
        	temp = 0;
        	
        	for(int j = 0; j < n; j++) {
        		if(land[j][i] == 1)
        			set.add(visited[j][i]);
        	}
        	
        	Iterator<Integer> it = set.iterator();
        	while(it.hasNext())
        		temp += map.get(it.next());
        	
        	answer = Math.max(answer, temp);
        }
        
        return answer;
    }
	
	public static void DFS(int x, int y, int temp) {
		visited[x][y] = temp;
		total++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < n && nx >= 0 && ny < m && ny >= 0)
				if(arr[nx][ny] == 1 && visited[nx][ny] == 0)
					DFS(nx, ny, temp);
		}
	}
}

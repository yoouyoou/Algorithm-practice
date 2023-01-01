package programmers;
import java.util.*;

public class 미로탈출 {
	
    static ArrayList<Node3>[] list;
    static boolean[] visited;
    static Set<Integer> set;
    static int answer = 0;

	public static void main(String[] args) {
		int n = 3;
		int start = 1;
		int end = 3;
		int[][] roads = {{1,2,3}, {3,2,3}};
		int[] traps = {2};
		
		solution(n, start, end, roads, traps);
		System.out.println();
		System.out.println(answer);
	}
	
    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        visited = new boolean[n+1];
        set = new HashSet<>();
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
            list[i] = new ArrayList<Node3>();
        
        //트랩 표시
        for(int i = 0; i < traps.length; i++)
        	set.add(traps[i]);
        
        //그래프 연결
        for(int i = 0; i < roads.length; i++) {
            list[roads[i][0]].add(new Node3(roads[i][1], roads[i][2], true));
            
            //트랩 노드라면 양방향이 될 수 있으므로
            if(set.contains(roads[i][0]) || set.contains(roads[i][1]))
            	list[roads[i][1]].add(new Node3(roads[i][0], roads[i][2], false));
        }
        
        dfs(start, end, 0);
        return answer;
    }
    
    public static void dfs(int start, int end, int cost){
    	System.out.println(start + " -> ");
        if(start == end){
        	System.out.println("여긴 와..?ㅎ");
            answer = cost;
        }
        
        visited[start] = true;
        
        for(int i = 0; i < list[start].size(); i++)
        	System.out.println(start + "와 연결된 노드: " + list[start].get(i).idx + ", " +list[start].get(i).isGo);
        
        //트랩에 포함되는 경우 방향 못가도록 바꾸기
        if(set.contains(start)) {
        	System.out.println(start + "에 연결된 노드 방향 변경");
        	for(int i = 0; i < list[start].size(); i++) {
        		if(list[start].get(i).isGo == true)
        			list[start].get(i).isGo = false;
        		else
        			changeDirection(list[start].get(i).idx, start);
        		
        		visited[list[start].get(i).idx] = false;
        	}
        }
        
        for(int i = 0; i < list[start].size(); i++)
        	System.out.println(start + "와 연결된 노드: " + list[start].get(i).idx + ", " +list[start].get(i).isGo);
        
        for(int i = 0; i < list[start].size(); i++) {
        	Node3 next = list[start].get(i);
        	if(!visited[next.idx] && next.isGo)
        		dfs(next.idx, end, cost + next.cost);
        }
    }
    
    public static void changeDirection(int reverseNode, int originNode) { //(트랩쪽으로 오는 노드번호, 트랩 노드)
    	for(int i = 0; i < list[reverseNode].size(); i++) {
    		if(list[reverseNode].get(i).idx == originNode) {
    			System.out.println(reverseNode+ "에서 오는" +originNode + "발견");
    			list[reverseNode].get(i).isGo = true;
//    			if(list[reverseNode].get(i).isGo)
//    				list[reverseNode].get(i).isGo = false;
//    			else {
//    				list[reverseNode].get(i).isGo = true;
//    				visited[list[reverseNode].get(i).idx] = false;
//    			}
    		}
    	}
    }
    
    public static void printList() {
    	for(int i = 1; i <= 3; i++)
    		System.out.println(i + "번과 연결된 노드: ");
    }

}

class Node3{
    int idx, cost;
    boolean isGo;	//이 방향으로 갈 수 있는지 여부
    
    public Node3(int idx, int cost, boolean isGo){
        this.idx = idx;
        this.cost = cost;
        this.isGo = isGo;
    }
}
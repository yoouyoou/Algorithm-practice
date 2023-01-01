package programmers;
import java.util.*;

public class �̷�Ż�� {
	
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
        
        //Ʈ�� ǥ��
        for(int i = 0; i < traps.length; i++)
        	set.add(traps[i]);
        
        //�׷��� ����
        for(int i = 0; i < roads.length; i++) {
            list[roads[i][0]].add(new Node3(roads[i][1], roads[i][2], true));
            
            //Ʈ�� ����� ������� �� �� �����Ƿ�
            if(set.contains(roads[i][0]) || set.contains(roads[i][1]))
            	list[roads[i][1]].add(new Node3(roads[i][0], roads[i][2], false));
        }
        
        dfs(start, end, 0);
        return answer;
    }
    
    public static void dfs(int start, int end, int cost){
    	System.out.println(start + " -> ");
        if(start == end){
        	System.out.println("���� ��..?��");
            answer = cost;
        }
        
        visited[start] = true;
        
        for(int i = 0; i < list[start].size(); i++)
        	System.out.println(start + "�� ����� ���: " + list[start].get(i).idx + ", " +list[start].get(i).isGo);
        
        //Ʈ���� ���ԵǴ� ��� ���� �������� �ٲٱ�
        if(set.contains(start)) {
        	System.out.println(start + "�� ����� ��� ���� ����");
        	for(int i = 0; i < list[start].size(); i++) {
        		if(list[start].get(i).isGo == true)
        			list[start].get(i).isGo = false;
        		else
        			changeDirection(list[start].get(i).idx, start);
        		
        		visited[list[start].get(i).idx] = false;
        	}
        }
        
        for(int i = 0; i < list[start].size(); i++)
        	System.out.println(start + "�� ����� ���: " + list[start].get(i).idx + ", " +list[start].get(i).isGo);
        
        for(int i = 0; i < list[start].size(); i++) {
        	Node3 next = list[start].get(i);
        	if(!visited[next.idx] && next.isGo)
        		dfs(next.idx, end, cost + next.cost);
        }
    }
    
    public static void changeDirection(int reverseNode, int originNode) { //(Ʈ�������� ���� ����ȣ, Ʈ�� ���)
    	for(int i = 0; i < list[reverseNode].size(); i++) {
    		if(list[reverseNode].get(i).idx == originNode) {
    			System.out.println(reverseNode+ "���� ����" +originNode + "�߰�");
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
    		System.out.println(i + "���� ����� ���: ");
    }

}

class Node3{
    int idx, cost;
    boolean isGo;	//�� �������� �� �� �ִ��� ����
    
    public Node3(int idx, int cost, boolean isGo){
        this.idx = idx;
        this.cost = cost;
        this.isGo = isGo;
    }
}
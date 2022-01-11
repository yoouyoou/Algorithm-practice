package p_등굣길;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p_way_to_school {
	static int dx [] = {0,0,1,-1};
    static int dy [] = {1,-1,0,0};
    static boolean visited[][];
    static boolean isPossible[][];
    static ArrayList<Node> map[][];
    static int n,m;
    static int ans =0;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        
        map = new ArrayList[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }		
        
        for(int i=0; i<m; i++) {
            t = br.readLine().split(" ");
            int x = Integer.parseInt(t[0]);
            int y = Integer.parseInt(t[1]);
            int a = Integer.parseInt(t[2]);
            int b = Integer.parseInt(t[3]);
            
            ArrayList<Node>list = map[x][y];
            list.add(new Node(a,b));
        }
        
        bfs();
        System.out.println(ans);       
	}
	
	public static void bfs() {
        Queue<Node> q= new LinkedList<>();
        visited = new boolean[n+1][n+1];
        isPossible = new boolean[n+1][n+1];
        ans++;
        ArrayList<Node> waiting = new ArrayList<>();
        visited[1][1]= true;
        isPossible[1][1] =true;
        q.add(new Node(1,1));
        
        while(!q.isEmpty()) {
            Node a = q.poll();
            
            for(Node light : map[a.x][a.y]) {
                if(!isPossible[light.x][light.y]) {
                    isPossible[light.x][light.y] = true;
                    System.out.println(light.x+" "+light.y+"에서 카운트 증가");
                    ans++;
                }  
            }       
            
            for(int i=0; i<4; i++) {
                int nx = a.x+dx[i];
                int ny = a.y+dy[i];
                
                if(isRange(nx,ny) && !visited[nx][ny]) {
                    if(isPossible[nx][ny]) {
                        q.add(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }
                    else {
                        waiting.add(new Node(nx,ny));
                    }
                }
            }
            
            int size = waiting.size();
            for(int i=0; i<size; i++) {
                Node poll = waiting.get(i);
                if(isPossible[poll.x][poll.y] && !visited[poll.x][poll.y]) {
                    q.add(new Node(poll.x,poll.y));
                    visited[poll.x][poll.y] = true;
                }
            }
        }         
	}
	
	public static boolean isRange(int x, int y) {
        if(x>=1 && y>=1 && x<=n && y<=n) {
            return true;
        }
        return false;
	}
}

class Node{
	int x, y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

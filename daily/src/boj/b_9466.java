package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//텀 프로젝트(골드3)
public class b_9466 {
	
	static int[] arr;
	static boolean[] visited;
	static boolean[] checked;
	static int N;
	static boolean flag;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < testCase; i++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N+1];
        	visited = new boolean[N+1];
        	checked = new boolean[N+1];
        	answer = 0;
        	
        	st = new StringTokenizer(br.readLine());
        	for(int j = 1; j <= N; j++)
        		arr[j] = Integer.parseInt(st.nextToken());
        	
        	for(int j = 1; j <= N; j++)
        		dfs(j);
        	
        	System.out.println(N - answer);
        }
		br.close();
	}
	
	public static void dfs(int x) {				
		visited[x] = true;
		int nextX = arr[x];
		
		if(!visited[nextX])
			dfs(nextX);
		else {
			if(!checked[nextX]) { //사이클을 지나온 적 없는 경우
				answer++;
				for(int i = nextX; i != x; i = arr[i])
					answer++;
			}
		}
		checked[x] = true;
	}
	
	/*
	public static void dfs(int x, int startIdx) {
		
		if(visited[x]) {
			if(x == startIdx) {
				flag = false;
			}
			else
				flag = true;
			return;
		}
		
		visited[x] = true;
		checked[x] = true;
		answer++;
		dfs(arr[x], startIdx);
		
		if(flag) {
			visited[x] = false;
			answer--;
		}
	}
	*/
}

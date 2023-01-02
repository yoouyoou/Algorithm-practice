package programmers;

import java.util.Arrays;
import java.util.HashMap;

public class 신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"con", "ryan"};//{"muzi", "frodo", "apeach", "neo"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};//{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 3;
		
		for(int s : solution(id_list, report, k))
			System.out.print(s);
	}

    public static int[] solution(String[] id_list, String[] report, int k) {
    	HashMap<String, Integer> map = new HashMap<>();
    	HashMap<String, Integer> count = new HashMap<>();
    	int num = id_list.length;
    	int idx = 0;
    	int[][] matrix = new int[num][num];
        int[] answer = new int[num];
        int[] user = new int[num];		//k번 이상 신고된 유저를 저장해두기 위한 배열
        Arrays.fill(user, -1);
        
        for(String s: id_list) {
        	map.put(s, idx++);
        	count.put(s, 0);
        }
        
        idx = 0;      
        for(int i = 0; i < report.length; i++) {
        	String[] str = report[i].split(" ");
        	System.out.println(str[0] + " -> " + str[1]);
        	if(matrix[map.get(str[0])][map.get(str[1])] == 0) {
            	matrix[map.get(str[0])][map.get(str[1])] = 1;
            	count.put(str[1], count.get(str[1]) + 1);
        	}
        	
        	if(count.get(str[1]) == k) {
        		user[idx++] = map.get(str[1]);
        		System.out.println(str[1] + "("+ map.get(str[1]) + ")" + " 신고 k번 달성!");
        	}
        }
        
        System.out.println("matrix-----");
        for(int i = 0; i < num; i++) {
        	for(int j = 0; j < num; j++)
        		System.out.print(matrix[i][j] + " ");
        	System.out.println();
        }
        
        idx = 0;
        while(user[idx] != -1) {
        	System.out.println(user[idx] + "가 k번 신고 당한 유저번호");
        	for(int i = 0; i < num; i++)
        		if(matrix[i][user[idx]] != 0)
        			answer[i]++;
        	idx++;
        }
        
        return answer;
    }
}

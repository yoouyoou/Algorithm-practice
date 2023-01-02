package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class 신고결과받기 {

	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"}; //{"con", "ryan"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; //{"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
		
		for(int s : solution(id_list, report, k))
			System.out.print(s);
	}

    public static int[] solution(String[] id_list, String[] report, int k) {
    	int num = id_list.length, idx = 0;
        int[] answer = new int[num];
        boolean[] flag = new boolean[num];
    	HashMap<String, Set<String>> map = new HashMap<>();
    	HashMap<String, Integer> noMap = new HashMap<>();
    	String[] user = new String[num];		//k번 이상 신고된 유저를 저장해두기 위한 배열
        
        for(String s: id_list) {
        	map.put(s, new HashSet<String>());
        	noMap.put(s, idx++);	//0부터 번호 넘버링
        }
        
        idx = 0;      
        for(int i = 0; i < report.length; i++) {
        	String[] str = report[i].split(" ");
        	map.get(str[1]).add(str[0]);		//신고당한 사람 조합에 신고자 넣기
        	map.put(str[1], map.get(str[1]));	//신고당한사람 갱신
        	
        	if(map.get(str[1]).size() == k && !flag[noMap.get(str[1])]) {
        		user[idx++] = str[1];						//신고당한 유저
        		flag[noMap.get(str[1])] = true;
        	}
        }
        
        idx = 0;
        while(user[idx] != null) {
        	Iterator<String> it = map.get(user[idx]).iterator();
        	while(it.hasNext()) {
        		answer[noMap.get(it.next())]++;
        	}	
        	idx++;
        }
        
        return answer;
    }
}

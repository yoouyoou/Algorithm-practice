package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class �Ű����ޱ� {

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
    	String[] user = new String[num];		//k�� �̻� �Ű�� ������ �����صα� ���� �迭
        
        for(String s: id_list) {
        	map.put(s, new HashSet<String>());
        	noMap.put(s, idx++);	//0���� ��ȣ �ѹ���
        }
        
        idx = 0;      
        for(int i = 0; i < report.length; i++) {
        	String[] str = report[i].split(" ");
        	map.get(str[1]).add(str[0]);		//�Ű���� ��� ���տ� �Ű��� �ֱ�
        	map.put(str[1], map.get(str[1]));	//�Ű���ѻ�� ����
        	
        	if(map.get(str[1]).size() == k && !flag[noMap.get(str[1])]) {
        		user[idx++] = str[1];						//�Ű���� ����
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

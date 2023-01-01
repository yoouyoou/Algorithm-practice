package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class 실패율 {

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int result[] = solution(N, stages);
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	public static int[] solution(int N, int[] stages) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Double> sortedMap = new HashMap<>();
        
        int num = stages.length;
        int[] answer = new int[N];
        
        //HashMap(스테이지, 0) 세팅
        for(int i = 1; i <= N; i++)
            map.put(i, 0);
        
        //HashMap(스테이지, 도달한 유저수) 갱신
        for(int i = 0; i < stages.length; i++){
            if(!map.containsKey(stages[i]))
                map.put(stages[i], 0);
            else
        	    map.replace(stages[i], map.get(stages[i]) + 1 );
        }
        
        //HashMap(스테이지, 실패율)
        int count = 1;
        List<Integer> list = new ArrayList<>(map.keySet());
        for(Integer key : list) {
        	if(key > N) {
        		sortedMap.put(key, 0.0);
        		continue;
        	}
        	sortedMap.put(key, (double)map.get(key) / num);   //count, (double)
        	num -= map.get(key);
        	count++;
        }
        
        //sortedMap value값으로 정렬
        List<Integer> list2 = new ArrayList<>(sortedMap.keySet());
        Collections.sort(list2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return sortedMap.get(o2).compareTo(sortedMap.get(o1));
			}
        	
        });
        
        count = 0;
        for(Integer key : list2) {
            if(key > N)
                continue;
        	answer[count++] = key;
        }
        
        return answer;
	}
}

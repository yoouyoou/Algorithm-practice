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
        double[] errors = new double[N];
        int[] number = new int[N];	// 분모 숫자 넣어두기
        int[] answer = new int[N];
        
        for(int i = 0; i < stages.length; i++) {
        	if(map.containsKey(stages[i]))
        		map.replace(stages[i], map.get(stages[i]) + 1 );
        	else
        		map.put(stages[i], 1);
        }
        
        int count = 1;
        List<Integer> list = new ArrayList<>(map.keySet());
        for(Integer key : list) {
        	System.out.println(key);
        	if(key > N) {
        		System.out.println("더커!");
        		sortedMap.put(count++, 0.0);
        		continue;
        	}
        	System.out.println((double)map.get(key) / num);
        	sortedMap.put(count, (double)map.get(key) / num);
        	//errors[count++] = (double)map.get(key) / num;
        	num -= map.get(key);
        	count++;
        }
        
        List<Integer> list2 = new ArrayList<>(sortedMap.keySet());
        Collections.sort(list2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return sortedMap.get(o2).compareTo(sortedMap.get(o1));
			}
        	
        });
        
        count = 0;
        for(Integer key : list2) {
        	answer[count++] = key;
        }
        /* HashMap상태 확인
        List<Integer> list = new ArrayList<>(map.keySet());
        for(Integer key : list)
        	System.out.println(key + ", " +map.get(key));
        */
        return answer;
	}
}

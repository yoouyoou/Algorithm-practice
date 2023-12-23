package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class l_1356 {

	public static void main(String[] args) {
		//int[] test = {0,1,2,3,4,5,6,7,8};
		int[] test2 = {1024,512,256,128,64,32,16,8,4,2,1};
		
		for(int a: sortByBits(test2))
			System.out.print(a +", ");
	}
	
	public static int[] sortByBits(int[] arr) {
		List<Integer> sequence = new ArrayList<>();
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();	// 1의 개수, List(배열의 숫자들)
        int[] answer = new int[arr.length];
        int idx = 0;

        for(int a: arr) {
        	int cnt = getBit1Num(a);
        	ArrayList<Integer> temp;
        	
        	if(map.containsKey(cnt)) {
        		temp = map.get(cnt);
        		temp.add(a);
        		map.put(cnt, temp);
        	}
        	else {
        		temp = new ArrayList<Integer>();
        		temp.add(a);
        		map.put(cnt, temp);
        		sequence.add(cnt);
        	}	
        }
        
        Collections.sort(sequence);
        for(int key: sequence) {
        	ArrayList<Integer> list = map.get(key);
        	Collections.sort(list);
        	
        	for(int num : list)
        		answer[idx++] = num;
        }
        
        return answer;
    }

    public static int getBit1Num(int num){
        int count = 0;

        while(num > 0){
        	if(num % 2 == 1)
        		count++;
        	
        	num /= 2;
        }
        
        //System.out.println("반한되는 1개의 비트수 : " + count);
        return count;
    }

}

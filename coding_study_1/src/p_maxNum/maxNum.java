package p_maxNum;

import java.util.ArrayList;
import java.util.Collections;

public class maxNum {

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));

	}
	
    public static String solution(int[] numbers) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
        String answer = "";
        String str = "";
        String[] s;
        
        for(int i = 0; i < numbers.length; i++) {
//        	System.out.println("정수형 배열에서 하나 꺼낸값: " + numbers[i]);
        	str = Integer.toString(numbers[i]);
//        	System.out.println("정수배열에서 하나 꺼내서 string으로 바꾼값: " + str);
        	s = str.split("");
        	for(int j = 0; j < s.length; j++) {
//        		System.out.print("배열의 첫번째 정수 string으로 만들고 쪼개기: ");
//        		System.out.println(s[j]);
        		list.add(Integer.parseInt(s[j]));
        	}
        }
        
        Collections.sort(list, Collections.reverseOrder());
        for(int i : list)
        	answer += String.valueOf(i);
        
        return answer;
    }

}

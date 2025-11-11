package programmers;

import java.util.Arrays;

public class PCCE기출문제_공원 {

	public static void main(String[] args) {
		int[] m = {5, 3, 2};
		String[][] p = {{"A", "A", "-1", "B", "B", "B", "B", "-1"}
					  , {"A", "A", "-1", "B", "B", "B", "B", "-1"}
					  , {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"}
					  , {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}
					  , {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"}
					  , {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
		
		System.out.println(solution(m, p));
	}
	
	public static int solution(int[] mats, String[][] park) {
		int row = park.length;
		int col = park[0].length;
		int answer = 0;
        Arrays.sort(mats);
        
        for(int i = mats.length-1; i >= 0; i--) {
        	int len = mats[i];
        	System.out.println("이번 len: " + len);
        	
        	for(int x = 0; x < row; x++) {
        		for(int y = 0; y < col; y++) {
        			if(park[x][y] == "-1") {
        				//빈값 발견
        				temp:
        				for(int t1 = x; t1 < x + len; t1++) {
        					for(int t2 = y; t2 < y + len; t2++) {
        						System.out.println("[" + t1 + "][" + t2 + "]");
        						if(t1 >= row || t2 >= col)
        							break temp;
        						if(park[t1][t2] != "-1")
        							break temp;
        					}
        					answer++;
        				}
        				if(answer == len)
        					return len;
        				else
        					answer = 0;
        			}
        		}
        	}
        }
        
        return -1;
    }
}

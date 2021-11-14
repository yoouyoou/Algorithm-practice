package p_mockTest;

public class p_mockTest {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = solution(a);
		for(int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
	}

	public static int[] solution(int[] answers) {
        int[] answer = {};
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        int idx1=0, idx2=0, idx3 = 0;
        int score1=0, score2=0, score3=0;
        
        for(int i = 0; i < answers.length; i++){
            if(i != 0){
                if(i % 5 == 0)
                    idx1 = 0;
                if(i % 8 == 0)
                    idx2 = 0;
                if(i % 10 == 0)
                    idx3 = 0;
            }
            if(answers[i] == p1[idx1++])
                score1++;
            if(answers[i] == p2[idx2++])
                score2++;
            if(answers[i] == p3[idx3++])
                score3++;   
        }
        
        
        //동점자 없음
        if(score1 != score2 && score1 != score3 && score2 != score3) {	 //세 개의 값이 모두 다를때
        	answer = new int[1];	// 답은 하나
            if(score1 > score2 && score1 > score3) { 	//socre1만 제일 클때
                answer[0] = 1;
            }
            else if(score2 > score1 && score2 > score3) //socre2만 제일 클때
                answer[0] = 2;
            else
                answer[0] = 3;
        } 
        else {	// 동점자 존재
        	if(score1 == score2 && score2 == score3) {	// 세명 다 같은 점수
        		answer = new int[3];
        		answer[0] = 1;
        		answer[1] = 2;
        		answer[2] = 3;
        	} else if(score1 == score2) {		
        		if(score1 > score3) {
        			answer = new int[2];
        			answer[0] = 1;
        			answer[1] = 2;
        		}else {
        			answer = new int[1];
        			answer[0] = 3;
        		}
        	} else if(score1 == score3) {		//score1과 score3가 같은 점수일때
        		if(score2 > score1) {
        			answer = new int[1];
        			answer[0] = 2;
        		}else {
        			answer = new int[2];
        			answer[0] = 1;
        			answer[1] = 3;
        		}
        	} else if(score2 == score3) {		//score2와 score3가 같은 점수일때
        		if(score1 > score2) {
        			answer = new int[1];
        			answer[0] = 1;
        		}else {
        			answer = new int[2];
        			answer[0] = 2;
        			answer[1] = 3;
        		}
        	}
        }
        
        return answer;
	}
}

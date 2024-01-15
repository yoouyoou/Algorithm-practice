package programmers;

public class PCCP기출_붕대감기 {

	public static void main(String[] args) {
		int[] bandage = {5, 1, 5};
		int health = 30;
		int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
		
		System.out.println(solution(bandage, health, attacks));
	}

	public static int solution(int[] bandage, int health, int[][] attacks) {
        int curHealth = health, idx = 0, startRecover = -1;
        int lastTime = attacks[attacks.length-1][0];
        
        for(int time = 1; time <= lastTime; time++) {
        	//공격이 왔다면
        	if(time == attacks[idx][0]) {
        		curHealth -= attacks[idx][1];
        		startRecover = 0;	//회복시작 플래그
        		idx++;
        		
        		if(curHealth <= 0) return -1;
        		continue;
        	}
        	//회복기일 경우
        	if(curHealth < health){
        		startRecover++;
        		curHealth += bandage[1];
        		
        		if(startRecover == bandage[0]) {	//연속시간 성공했을 때
        			curHealth += bandage[2];
        			startRecover = 0;
        		}
        			
        		if(curHealth > health)
        			curHealth = health;
        	}
        }
        
        return curHealth;
    }
}

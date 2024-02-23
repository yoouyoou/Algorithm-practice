package programmers;

//카페 확장
public class PCCP모의고사2_3 {

	public static void main(String[] args) {
		int[] menu = {5,6,7,11};
		int[] order = {1,2,3,3,2,1,1};
		int k = 10;
		System.out.println(solution(menu, order, k));
	}

	public static int solution(int[] menu, int[] order, int k) {
        int max = 1, people = order.length;
        int curPeople = 1;	//현재 카페에 있는 인원
        int orderIndex = 0, enterIndex = 1;	//주문하는 사람 인덱스, 사람 들어오는 시간 카운트 인덱스
        int beverage = menu[order[orderIndex++]];	//음료제조시간
        
        for(int i = 0; i <= (people-1) * k; i++) {
        	System.out.println("\n현재시간: "  + i + " (" + curPeople + ")");
        	
        	//음료 다 만들었을 경우
        	if(orderIndex < people && i == beverage) {
        		curPeople--;
        		if(curPeople == 0 && i < k * enterIndex) {	//다음사람이 들어올 시간보다 현재시간이 더 빠르면서 지금 아무 사람도 없을때
        			beverage = (k * enterIndex) + menu[order[orderIndex++]];
        			System.out.println("다음 음료가 만들어지는 시간1: " + beverage);
        		}
        		else {
        			beverage = i + menu[order[orderIndex++]];
        			System.out.println("다음 음료가 만들어지는 시간2: " + beverage);
        		}
        	}
        	//손님 들어올 시간
        	if(enterIndex <= people && i == k * enterIndex) {
        		curPeople++;
        		enterIndex++;
        		max = Math.max(max, curPeople);
        	}
        }
        
        return max;
    }
}

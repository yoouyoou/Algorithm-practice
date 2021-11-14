package p_printer;

public class p_printer {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		
		System.out.println(solution(priorities, location));
	}
	
	public static void printArr(int[] arr) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	public static int solution(int[] priorities, int location) {
		int[] moveIndex = new int[priorities.length];
		int current = 0, temp = 0, m_temp = 0;
		boolean isExist = false;
		
		System.out.println("초기 배열 출력");
		printArr(priorities);

		// moveIndex에 초기 인덱스 대입
		for(int i = 0; i < priorities.length; i++)
			moveIndex[i] = i;
		
		// priorities 순서 정하기
//		for(int i = 0; i < priorities.length; i++) {
		while(temp != priorities.length) {
			current = priorities[temp];
			
			for(int j = temp+1; j < priorities.length; j++)
				if(current < priorities[j]) 	// 우선순위가 더 높은게 있나 체크
					isExist = true;
			
			if(isExist) {	// 순서 변경이 필요함
				for(int k = temp; k < priorities.length-1; k++) 
					priorities[k] = priorities[k+1];	// 한칸씩 앞당기기
				priorities[priorities.length-1] = current;	//현재 인덱스 맨 뒤로 보내기
				
				for(int k = temp; k < priorities.length; k++)
					if(moveIndex[k] >= m_temp) {	// 이미 순서가 정해진 인덱스는 제외하고 변경시키기 위해
						if(moveIndex[k] == m_temp)	// 맨 앞에 있으면
							moveIndex[k] = priorities.length - 1;	// 맨 뒤 인덱스로 바꿔줌
						else
							moveIndex[k] -= 1;	// 한 칸씩 앞으로 당겨지므로
					}
			}
			
			if(!isExist) { 	// 우선순위가 높은게 없다면 그게 일순위
				temp++;
				m_temp++;
			}
			
			isExist = false;
			System.out.println("배열 출력");
			printArr(priorities);
		}
    	
		System.out.println("-------------");
		printArr(moveIndex);
		return moveIndex[location] + 1;
    }

}

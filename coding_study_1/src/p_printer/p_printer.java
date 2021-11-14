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
		
		System.out.println("�ʱ� �迭 ���");
		printArr(priorities);

		// moveIndex�� �ʱ� �ε��� ����
		for(int i = 0; i < priorities.length; i++)
			moveIndex[i] = i;
		
		// priorities ���� ���ϱ�
//		for(int i = 0; i < priorities.length; i++) {
		while(temp != priorities.length) {
			current = priorities[temp];
			
			for(int j = temp+1; j < priorities.length; j++)
				if(current < priorities[j]) 	// �켱������ �� ������ �ֳ� üũ
					isExist = true;
			
			if(isExist) {	// ���� ������ �ʿ���
				for(int k = temp; k < priorities.length-1; k++) 
					priorities[k] = priorities[k+1];	// ��ĭ�� �մ���
				priorities[priorities.length-1] = current;	//���� �ε��� �� �ڷ� ������
				
				for(int k = temp; k < priorities.length; k++)
					if(moveIndex[k] >= m_temp) {	// �̹� ������ ������ �ε����� �����ϰ� �����Ű�� ����
						if(moveIndex[k] == m_temp)	// �� �տ� ������
							moveIndex[k] = priorities.length - 1;	// �� �� �ε����� �ٲ���
						else
							moveIndex[k] -= 1;	// �� ĭ�� ������ ������Ƿ�
					}
			}
			
			if(!isExist) { 	// �켱������ ������ ���ٸ� �װ� �ϼ���
				temp++;
				m_temp++;
			}
			
			isExist = false;
			System.out.println("�迭 ���");
			printArr(priorities);
		}
    	
		System.out.println("-------------");
		printArr(moveIndex);
		return moveIndex[location] + 1;
    }

}

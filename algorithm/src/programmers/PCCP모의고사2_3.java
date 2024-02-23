package programmers;

//ī�� Ȯ��
public class PCCP���ǰ��2_3 {

	public static void main(String[] args) {
		int[] menu = {5,6,7,11};
		int[] order = {1,2,3,3,2,1,1};
		int k = 10;
		System.out.println(solution(menu, order, k));
	}

	public static int solution(int[] menu, int[] order, int k) {
        int max = 1, people = order.length;
        int curPeople = 1;	//���� ī�信 �ִ� �ο�
        int orderIndex = 0, enterIndex = 1;	//�ֹ��ϴ� ��� �ε���, ��� ������ �ð� ī��Ʈ �ε���
        int beverage = menu[order[orderIndex++]];	//���������ð�
        
        for(int i = 0; i <= (people-1) * k; i++) {
        	System.out.println("\n����ð�: "  + i + " (" + curPeople + ")");
        	
        	//���� �� ������� ���
        	if(orderIndex < people && i == beverage) {
        		curPeople--;
        		if(curPeople == 0 && i < k * enterIndex) {	//��������� ���� �ð����� ����ð��� �� �����鼭 ���� �ƹ� ����� ������
        			beverage = (k * enterIndex) + menu[order[orderIndex++]];
        			System.out.println("���� ���ᰡ ��������� �ð�1: " + beverage);
        		}
        		else {
        			beverage = i + menu[order[orderIndex++]];
        			System.out.println("���� ���ᰡ ��������� �ð�2: " + beverage);
        		}
        	}
        	//�մ� ���� �ð�
        	if(enterIndex <= people && i == k * enterIndex) {
        		curPeople++;
        		enterIndex++;
        		max = Math.max(max, curPeople);
        	}
        }
        
        return max;
    }
}

package leetcode;

public class l_3201 {

	public static void main(String[] args) {
		int[] test = {1,5,9,4,2};
		System.out.println(maximumLength(test));
	}
	
	public static int maximumLength(int[] nums) {
		int evenNum = 0;	//¦�� ����
		int oddNum = 0;		//Ȧ�� ����
		
		for(int num: nums) {
			if(num % 2 == 0)
				evenNum++;
			else
				oddNum++;
		}
		
		if(evenNum == 0) return oddNum;
		if(oddNum == 0) return evenNum;
		
		int evenDp = 0;	//���ڿ� �������� ¦�� ���� �� �ִ� �ִ� ����
		int oddDp = 0;	//Ȧ�� ����
		
		for(int num: nums) {
			if(num % 2 == 0)
				evenDp = Math.max(evenDp, oddDp + 1);
			else
				oddDp = Math.max(oddDp, evenDp + 1);
		}
		
		return Math.max(Math.max(evenNum, oddNum), Math.max(evenDp, oddDp));
	}
	
}

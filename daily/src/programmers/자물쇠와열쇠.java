package programmers;

public class �ڹ���Ϳ��� {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock){
		int M = key.length;		//key�� ���� ����
		int N = lock.length;	//lock�� ���� ����
		int maxIdx = N-M;	// (N-1) - (M-1) �ִ� �� �� �ִ� �ε��� ��
		
		for(int i = 0; i < maxIdx; i++) {
			for(int j = 0; j < maxIdx; j++) {
				if(key[j] == lock[j])
					break;
			}
		}
				
		return false;
	}

}

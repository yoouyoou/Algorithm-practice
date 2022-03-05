package programmers;

public class 자물쇠와열쇠 {

	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		
		System.out.println(solution(key, lock));
	}
	
	public static boolean solution(int[][] key, int[][] lock){
		int M = key.length;		//key한 변의 길이
		int N = lock.length;	//lock한 변의 길이
		int maxIdx = N-M;	// (N-1) - (M-1) 최대 갈 수 있는 인덱스 값
		
		for(int i = 0; i < maxIdx; i++) {
			for(int j = 0; j < maxIdx; j++) {
				if(key[j] == lock[j])
					break;
			}
		}
				
		return false;
	}

}

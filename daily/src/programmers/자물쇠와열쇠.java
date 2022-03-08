package programmers;

import java.util.ArrayList;

public class �ڹ���Ϳ��� {
	
	public static void main(String[] args) {
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

		System.out.println(solution(key, lock));
	}
	
	//�׳� ���� �ݺ�
	public static boolean solution(int[][] key, int[][] lock){
		ArrayList<Point> lockList = new ArrayList<>();
		ArrayList<Point> keyList = new ArrayList<>();
		
		for(int i = 0; i < lock.length; i++)
			for(int j = 0; j < lock.length; j++)
				if(lock[i][j] == 0)	//Ȩ�̶��
					lockList.add(new Point(i, j));
		
		for(int i = 0; i < key.length; i++)
			for(int j = 0; j < key.length; j++)
				if(key[i][j] == 1)	//���� �κ��̶��
					keyList.add(new Point(i, j));
		
		return true;
	}

}


//��ǥ Ŭ���� 		// list�����ϱ�
class Point implements Comparable<Point>{
	int r, c;
	
	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public int compareTo(Point arg0) {
		if(this.r < arg0.r)
			return -1;
		return 0;
	}
}

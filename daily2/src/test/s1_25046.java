package test;
import java.util.*;

//사각형 게임(Small)
public class s1_25046 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();

	}

}

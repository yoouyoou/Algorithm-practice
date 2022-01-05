package b_light_up;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// °ñµå3
public class b_11967 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		ArrayList<HashMap<Integer, Integer>> list[] = new ArrayList[M];
		
		for(int i = 0; i < M; i++)
			list[i] = new ArrayList<HashMap<Integer, Integer>>();
		
		for(int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			HashMap<Integer, Integer> xy = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> ab = new HashMap<Integer, Integer>();
			xy.put(x, y);
			ab.put(a, b);
			//if(list)
		}

	}

}

package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b_1969 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		String[][] s = new String[N][M];
		int[] dna = new int[4];		//A, C, G, T
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for(int j = 0; j < M; j++)
				s[i][j] = str[j];
		}
		
		String ans = "";
		int hd = 0;
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(s[j][i].equals("A"))
					dna[0]++;
				else if(s[j][i].equals("C"))
					dna[1]++;
				else if(s[j][i].equals("G"))
					dna[2]++;
				else
					dna[3]++;
			}
			int max = 0;
			int maxIdx = 0;
			for(int k = 0; k < 4; k++)
				if(dna[k] > max) {
					max = dna[k];
					maxIdx = k;
				}
			for(int k = 0; k < 4; k++)
				if(k != maxIdx)
					hd += dna[k];
			
			if(maxIdx == 0)
				ans += "A";
			else if(maxIdx == 1)
				ans += "C";
			else if(maxIdx == 2)
				ans += "G";
			else
				ans += "T";
			
			dna = new int[4];
		}
		
		System.out.println(ans);
		System.out.println(hd);
		br.close();
	}

}

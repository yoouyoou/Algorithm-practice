package leetcode;

import java.util.HashSet;
import java.util.Set;

public class l_36 {

	public static void main(String[] args) {
		char[][] test = {{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}};
		
		System.out.println(isValidSudoKu(test));
	}
	
	public static boolean isValidSudoKu(char[][] board) {
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				char cur = board[i][j];
				
				if(cur != '.') 
					if(!set.add(i + "row" + cur) || !set.add(j + "col" + cur) || !set.add(i/3 + "," + j/3 + "subBox" + cur))
						return false;	
			}
		}
		return true;
	}

}

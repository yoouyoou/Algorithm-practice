package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class l_5 {

	public static void main(String[] args) {
		//testcase1 -> 21
		int[] abilites = {2, 8, 3, 6, 1, 9, 1, 9};
		int k = 2;
		
		//testcase2 -> 22
//		int[] abilites = {7, 6, 8, 9, 10};
//		int k = 1;

		int myteam = 0;
		Arrays.sort(abilites);	//¿À¸¥Â÷¼ø Á¤·Ä
		
		//µÎ°³¾¿ Â¦Áþ±â
		//0³Ö¾î¼­ Â¦¼ö¸ÂÃß±â
		
		//ÆÀÀÌ Â¦¼öÀÏ °æ¿ì
		if(abilites.length % 2 == 0) {
			for(int i = abilites.length-1; i >= 0; i-=2) {
				if(abilites[i] != abilites[i-1]) {
					if(k > 0) {
						myteam += abilites[i];
						System.out.println(abilites[i]);
						k--;	
					}
				}
				else
					myteam += abilites[i-1];
			}
		}
		//ÆÀÀÌ È¦¼öÀÏ °æ¿ì
		else {
			for(int i = abilites.length-1; i >= 1; i -=2) {
				
			}
			
		}
		
		System.out.println(myteam);
	}

}

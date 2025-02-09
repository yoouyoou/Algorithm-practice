package leetcode;

public class l_1790 {

	public static void main(String[] args) {
		String s1 = "bank";
		String s2 = "kanb";
		
		System.out.println(areAlmostEqual(s1, s2));
	}

	public static boolean areAlmostEqual(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		
		boolean flag = true;
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		
		for(int i = 0; i < ch1.length; i++) {
			System.out.println(ch1[i] + " <-> " + ch2[i]);
			if(ch1[i] != ch2[i]) {
				if(!flag)
					return false;
				int j = i + 1;
				while(true) {
					if(j >= ch2.length)
						return false;
					if(ch1[i] == ch2[j] && ch1[j] == ch2[i]) {
						/*
						 * 한 문자당 한번의 스왑이 가능했을 경우
						 ch1[j] = Character.toUpperCase(ch2[i]);
						 ch2[i] = ch2[j];
						 ch2[j] = ch1[j];
						*/
						ch2[j] = ch1[j];
						flag = false;
						break;
					}
					j++;
				}
			}
		}
		
		return true;
	}
	
	public static void print(char[] ch1, char[] ch2) {
		for(char c1: ch1)
			System.out.print(c1 + " ");
		System.out.println();
		
		for(char c2: ch2)
			System.out.print(c2 + " ");
		System.out.println();
	}
}

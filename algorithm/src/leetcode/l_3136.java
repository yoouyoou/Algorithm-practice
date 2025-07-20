package leetcode;

public class l_3136 {

	public static void main(String[] args) {
		String case1 = "AhI";
		System.out.println(isValid(case1));
	}
	
	public static boolean isValid(String word) {
		int vowelCount = 0;		//모음 카운트
		int consonantCount = 0;	//자음 카운트
		
		if(word.length() < 3)
			return false;
		
		for(char c: word.toCharArray()) {
			//정수가 아닌경우
			if(!Character.isDigit(c)) {
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
				   c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
					vowelCount++;
				}else {
					if(c == '@' || c == '#' || c == '$')
						return false;
					consonantCount++;
				}
			}
		}
		
		if(vowelCount == 0 || consonantCount == 0)
			return false;
		
		return true;
    }

}

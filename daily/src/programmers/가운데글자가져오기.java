package programmers;

public class 가운데글자가져오기 {

	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "qwer";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}
	
	public static String solution(String s) {
		//짝수
		if(s.length() % 2 != 0) {
			return String.valueOf(s.charAt(s.length() / 2));
		}
		else {
			int temp = s.length() / 2;
			return s.substring(temp - 1, temp + 1);
		}
	}

}

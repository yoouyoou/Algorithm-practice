package programmers;

public class ������ڰ������� {

	public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "qwer";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}
	
	public static String solution(String s) {
		//¦��
		if(s.length() % 2 != 0) {
			return String.valueOf(s.charAt(s.length() / 2));
		}
		else {
			int temp = s.length() / 2;
			return s.substring(temp - 1, temp + 1);
		}
	}

}

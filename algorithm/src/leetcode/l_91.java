package leetcode;

public class l_91 {

	public static void main(String[] args) {
		String s1 = "12";
		String s2 = "226";
		String s3 = "06";
		
		System.out.println(numDecodings(s1));
		System.out.println(numDecodings(s2));
		System.out.println(numDecodings(s3));
	}
	
	public static int numDecodings(String s) {
		int ans = 0;
		int strNum = Integer.parseInt(s);
		int num = strNum;
		boolean flag = true;
		
		while(num != 0) {
			int remain = num % 10;
			num /= 10;
			
			if(remain < 1 || remain > 26) {
				flag = false;
				break;
			}
		}
		
		if(!flag) {
			ans++;
			flag = true;
		}
		
		num = strNum;
		while(num != 0) {
			
		}
		
		
		return ans;
	}

}

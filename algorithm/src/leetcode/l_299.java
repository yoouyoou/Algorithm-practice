package leetcode;

import java.util.ArrayList;

public class l_299 {

	public static void main(String[] args) {
		System.out.println(getHint("1807", "7810"));
		System.out.println(getHint("1123", "0111"));
	}
	
	public static String getHint(String secret, String guess) {
		ArrayList<Character> gList = new ArrayList<>();
        ArrayList<Character> sList = new ArrayList<>();
        int A = 0, B = 0;

        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i))
                A++;
            else{
                gList.add(guess.charAt(i));
                sList.add(secret.charAt(i));
            }
        }
        
        for(int i = 0; i < gList.size(); i++){
        	System.out.println(i);
        	System.out.print("gList 리스트 : ");
        	
        	for(char c: gList)
        		System.out.print(c + " ");
        	System.out.print("\nsList 리스트 : ");
        	
        	for(char c: sList)
        		System.out.print(c + " ");
        	System.out.println("\n");
        	
        	if(sList.contains(gList.get(i))) {
        		System.out.println("gList: " + gList.get(i));
        		B++;	
        		sList.remove(sList.indexOf(gList.get(i)));
        		sList.add('N');
        	}
        }

        return A + "A" + B + "B";
	}
}

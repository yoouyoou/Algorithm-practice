package programmers;

import java.util.HashMap;

public class KAKAO_가장많이받은선물 {

	public static void main(String[] args) {
		String[] f = {"muzi", "ryan", "frodo", "neo"};
		String[] g = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
		
		System.out.println(solution(f, g));
	}
	
	public static int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> map = new HashMap<>();
        int[][] giftCount = new int[friends.length][friends.length];
        int[] giftIndex1 = new int[friends.length];
        int[] giftIndex2 = new int[friends.length];
        int[] finalIndex = new int[friends.length];
        
        int temp = 0;
        for(String str: friends)
        	map.put(str, temp++);
        
        for(int i = 0; i < gifts.length; i++) {
        	String[] str = gifts[i].split(" ");
        	giftCount[map.get(str[0])][map.get(str[1])]++;
        	giftIndex1[map.get(str[0])]++;
        	giftIndex2[map.get(str[1])]++;
        }
        
        for(int i = 0; i < friends.length; i++) {
        	String a = friends[i];
        	for(int j = i + 1; j < friends.length; j++) {
        		String b = friends[j];
        		if(giftCount[map.get(a)][map.get(b)] > giftCount[map.get(b)][map.get(a)])
        			finalIndex[map.get(a)]++;
        		else if(giftCount[map.get(a)][map.get(b)] < giftCount[map.get(b)][map.get(a)])
        			finalIndex[map.get(b)]++;
        		else {
        			if(giftIndex1[map.get(a)] - giftIndex2[map.get(a)] > giftIndex1[map.get(b)] - giftIndex2[map.get(b)])
        				finalIndex[map.get(a)]++;
        			else if(giftIndex1[map.get(a)] - giftIndex2[map.get(a)] < giftIndex1[map.get(b)] - giftIndex2[map.get(b)])
        				finalIndex[map.get(b)]++;
        		}
        	}
        }
        
        int answer = 0;
        for(int a: finalIndex)
        	answer = Math.max(answer, a);
        
        return answer;
    }

}

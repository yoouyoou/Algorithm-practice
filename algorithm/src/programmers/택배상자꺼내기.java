package programmers;

public class 택배상자꺼내기 {

	public static void main(String[] args) {
		int n = 5;
		int w = 3;
		int num = 1;
		
		System.out.println(solution(n, w, num));
	}
	
	public static int solution(int n, int w, int num) {
        int answer = 1, idx = 0, floor = 1;
        int height = n / w;
        int width = n % w;
        boolean flag = false;
        
        System.out.println("height: " + height + ", width: " + width);
        
        for(int i = 1; i <= num; i++) {
        	idx++;
        	if(i % w == 0) {
        		flag = !flag;
        		floor++;
        		idx = 0;
        	}
        }
        
        // 만약 제일 마지막 인덱스여서 층수 넘어가고 for문 탈출했을 경우 대비
        if(idx == 0) {
        	idx = w;
        	floor -= 1;
        	flag = !flag;
        }
        
        System.out.println("idx: " + idx +", floor: " + floor + ", " + flag);
        answer += height - floor;
        height += 1;
        
        if((height % 2 == 0 && !flag) || (height % 2 != 0 && flag))
        	idx = w - idx + 1;
        
        if(width >= idx)
        	answer++;
        
        return answer;
    }

}

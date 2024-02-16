package programmers;

public class PCCP모의고사2_1 {

	public static void main(String[] args) {
		String command = "GRGLGRG";
		int test[] = solution(command);
		System.out.println(test[0] + ", " + test[1]);
	}

	public static int[] solution(String command) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] answer = new int[2];
        int x = 0, y = 0, direction = 0;
        
        for(int i = 0; i < command.length(); i++){
            char cmd = command.charAt(i);
            if(cmd == 'G'){
                x += dx[direction];
                y += dy[direction];
            }
            else if(cmd == 'B'){
                x += dx[direction] * -1;
                y += dy[direction] * -1;
            }
            else if(cmd == 'L'){
                if(direction == 0) direction = 3;
                else direction -= 1;
            }
            else if(cmd == 'R'){
                if(direction == 3) direction = 0;
                else direction += 1;
            }
        }
        
        answer[0] = x;
        answer[1] = y;
        return answer;
    }
}

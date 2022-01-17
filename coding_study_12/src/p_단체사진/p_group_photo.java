package p_단체사진;

public class p_group_photo {

    static int answer = 0;
    static int n;
    static String[] datas = {"N~F=0", "R~T>2"}; //"M~C<2", "C~M>1"   "N~F=0", "R~T>2"
    static char[] name = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
	public static void main(String[] args) {
		n = 2;
        int[] line = {0,1,2,3,4,5,6,7};
        int[] output = new int[8];
        boolean[] visited = new boolean[8];
        permutation(line, output, visited, 0, 8, 8);
        System.out.println(answer);
	}

    public static boolean confirm(int[] output){
        for(String data : datas){
        	
        	for(int i = 0; i < output.length; i++)
        		System.out.print(name[output[i]]);
        	System.out.println();
        	
            char[] arr = data.toCharArray();
            char a = arr[0];
            char b = arr[2];
            char operator = arr[3];
            char distance = arr[4];
            int count = 0;
            boolean check = false;

            //조건이 = 인 경우
            if(operator == '='){
                for(int i = 0; i < 8; i++){
                    if(check)
                        count++;
                    if(name[output[i]] == b || name[output[i]] == a) {
                    	if(check)
                    		check = false;
                    	else
                    		check = true;
                    }
                }
                System.out.print(count-1 + "=");
                System.out.println(distance-'0');
                if(count-1 != distance-'0')
                    return false;
            }
            //조건이 > 인 경우
            else if (operator == '>'){
                for(int i = 0; i < 8; i++){
                    if(check)
                        count++;
                    if(name[output[i]] == b || name[output[i]] == a) {
                    	if(check)
                    		check = false;
                    	else
                    		check = true;
                    }
                }
                System.out.print(count-1 + ">");
                System.out.println(distance-'0');
                if(!(count-1 > distance-'0'))
                    return false;
            }
            //조건이 < 인 경우
            else{
                for(int i = 0; i < 8; i++){
                    if(check)
                        count++;
                    if(name[output[i]] == b || name[output[i]] == a) {
                    	if(check)
                    		check = false;
                    	else
                    		check = true;
                    }
                }
                System.out.print(count-1 + "<");
                System.out.println(distance-'0');
                if(!(count-1 < distance-'0'))
                    return false;
            }
        }
        System.out.println("True로 리턴");
        return true;
    }
    
    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) { 
        if(depth == r){
            if(confirm(output))
                answer++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(visited[i] != true){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth+1, n, r);
                output[depth] = 0;
                visited[i] = false;
            }
        }
    }
    
}

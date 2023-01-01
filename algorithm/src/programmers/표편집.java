package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class ǥ���� {

	public static void main(String[] args) {
		int n = 8;	//����
		int k = 2; //���� ��
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		
		System.out.println(solution(n, k, cmd));
	}
	
    public static String solution(int n, int k1, String[] cmd) {
        Stack<Node> st = new Stack<Node>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(i);
        int k = k1;
        
        for(int i = 0; i < cmd.length; i++){
            System.out.println("[" + i + "] ����k�� " + k);
            for(int j = 0; j < list.size(); j++){
                System.out.print(j + "��: ");
                System.out.println(list.get(j));
            }
            
            if(cmd[i].startsWith("D")){
//                k += cmd[i].charAt(2) - '0';
            	k += Integer.parseInt(cmd[i].split(" ")[1]);
                if(k > list.size()-1)
                    k = list.size()-1;
            }
            else if(cmd[i].startsWith("U")){
                k -= cmd[i].charAt(2) - '0';
                if(k < 0)
                    k = 0;
            }
            else if(cmd[i].equals("C")){    //���� �� ���� �� �Ʒ� �� ����
                st.push(new Node(k, list.get(k)));  //���̶� �� ���� ������ȣ
                list.remove(k);                     //����Ʈ���� ���������ν� ������-> �ε���k�� �״��
                if(k == list.size())
                    k--;
            }
            else if(cmd[i].equals("Z")){    //���� �ֱٿ� ������ �� ���� (���� �������� �ȹٲ�)
                Node cur = st.pop();        //
                if(cur.idx == list.size()-1)
                    list.add(cur.number);
                else
                    list.add(cur.idx, cur.number);
                if(cur.idx <= k)
                	k++; 
            }
        }
        System.out.println("[last]");
        for(int j = 0; j < list.size(); j++){
               System.out.print(j + "��: ");
               System.out.println(list.get(j));
         }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(list.contains(i))
                answer.append("O");
            else
                answer.append("X");
        }
        
        return answer.toString();
    }

}

class Node{
    int idx, number;
    public Node(int idx, int number){
        this.idx = idx;
        this.number = number;
    }
}
package test;

import java.util.ArrayList;
import java.util.Arrays;

public class l_3 {

	public static void main(String[] args) {
		//testcase1
		int num_teams = 3;
		String[] remote_tasks = {"development","marketing", "hometask"};
		String[] office_tasks = {"recruitment", "education", "officetask"};
		String[] employees = {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};
		
		//testcase2
//		int num_teams = 2;
//		String[] remote_tasks = {"design"};
//		String[] office_tasks = {"building","supervise"};
//		String[] employees = {"2 design","1 supervise building design","1 design","2 design"};
		
		ArrayList<Integer> ans = solution(num_teams, remote_tasks, office_tasks, employees);
		for(int a : ans)
			System.out.print(a + " ");
	}
	
	public static ArrayList<Integer> solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		int eo_idx = 0;
		int er_idx = 0;
		int[][] e_office = new int[num_teams + 1][employees.length];
		int[][] e_remote = new int[num_teams + 1][employees.length];
		
		for(int i = 1; i <= num_teams; i++) {
			for(int j = 0; j < employees.length; j++) {
				e_office[i][j] = 101;
				e_remote[i][j] = 101;
			}
		}
		
		int en = 1;
		for(String e: employees) {
			boolean isOffice = false;
			String[] str = e.split(" ");
			int tn = Integer.parseInt(str[0]);
			
			for(int i = 1; i < str.length; i++) {
				if(isOffice(str[i], office_tasks)) {	//�ϳ��� ��� �����̸�
					isOffice = true;
					break;
				}	
			}
			
			if(isOffice)
				e_office[tn][eo_idx++] = en;
			else
				e_remote[tn][er_idx++] = en;
			
			en++;
		}
		
		//������� �� �� �� ����/��� ��� ��ȣ�� ��Ƴ��� �迭�� �ϼ��� 
		//���� ���û���ڸ� �̾Ƴ���
		for(int i = 1; i <= num_teams; i++) {
			Arrays.sort(e_office[i]);
			Arrays.sort(e_remote[i]);
		}
		 
		/* �߰� �迭 Ȯ��
		System.out.println("---------e_officeȮ��---------");
		for(int i = 1; i <= num_teams; i++) {
			for(int j = 0; j < employees.length; j++)
				System.out.print(e_office[i][j] + " ");
			System.out.println();
		}
		System.out.println("--------e_remoteȮ��---------");
		for(int i = 1; i <= num_teams; i++) {
			for(int j = 0; j < employees.length; j++)
				System.out.print(e_remote[i][j] + " ");
			System.out.println();
		}
		*/
				
		for(int i = 1; i <= num_teams; i++) {
//			boolean isCheck = false;
			
			if(e_office[i][0] == 101) {		//����ϴ� ����� �ƹ��� ������
				for(int k = 1; e_remote[i][k] != 101; k++)
					answer.add(e_remote[i][k]);
				continue;
			}
			
			//����ϴ� ��� ����
			for(int k = 0; e_remote[i][k] != 101; k++)
				answer.add(e_remote[i][k]);
			
		}
		
		return answer;
	}

	//task�� ��� �������� Ȯ�����ִ� �Լ� (��پ����̸� true)
	public static boolean isOffice(String task, String[] office_tasks) {
		for(int j = 0; j < office_tasks.length; j++) {
			if(task.equals(office_tasks[j]))
				return true;
		}
		return false;
	}
}

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
				if(isOffice(str[i], office_tasks)) {	//하나라도 출근 업무이면
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
		
		//여기까지 각 팀 별 재택/출근 사원 번호를 모아놓은 배열이 완성됨 
		//이제 재택사원자만 뽑아내기
		for(int i = 1; i <= num_teams; i++) {
			Arrays.sort(e_office[i]);
			Arrays.sort(e_remote[i]);
		}
		 
		/* 중간 배열 확인
		System.out.println("---------e_office확인---------");
		for(int i = 1; i <= num_teams; i++) {
			for(int j = 0; j < employees.length; j++)
				System.out.print(e_office[i][j] + " ");
			System.out.println();
		}
		System.out.println("--------e_remote확인---------");
		for(int i = 1; i <= num_teams; i++) {
			for(int j = 0; j < employees.length; j++)
				System.out.print(e_remote[i][j] + " ");
			System.out.println();
		}
		*/
				
		for(int i = 1; i <= num_teams; i++) {
//			boolean isCheck = false;
			
			if(e_office[i][0] == 101) {		//출근하는 사원이 아무도 없으면
				for(int k = 1; e_remote[i][k] != 101; k++)
					answer.add(e_remote[i][k]);
				continue;
			}
			
			//출근하는 사람 존재
			for(int k = 0; e_remote[i][k] != 101; k++)
				answer.add(e_remote[i][k]);
			
		}
		
		return answer;
	}

	//task가 출근 업무인지 확인해주는 함수 (출근업무이면 true)
	public static boolean isOffice(String task, String[] office_tasks) {
		for(int j = 0; j < office_tasks.length; j++) {
			if(task.equals(office_tasks[j]))
				return true;
		}
		return false;
	}
}

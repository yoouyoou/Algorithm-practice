package test;
import java.util.*;

//������
public class s2_25044 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;	//���� Ƚ��
		ArrayList<Integer> list = new ArrayList<>();	//���� �ð��� �� �־�� ����Ʈ
		
		int[] increase = {180, 180, 1080};
		int N = sc.nextInt();	//��¥
		int K = sc.nextInt();	//�����Ǵ� ��
		int minute = 900;
		
		//��� ������ ���ļ� ������ �� ��
		//0�� °�� �Ϸ� ���� 1440��
		int Nstart = 1440 * N;	//N��°�� ���۵Ǵ� ���� �� (�Ϸ� 1440�� * �ϼ�)
		int limit = Nstart + 1440;
		if(900 >= Nstart) {		//���� 900������ �����ϱ� ������ 0��°�� �ش��ϴ� �� ���� �־���� ��
			list.add(900);
			num++;
		}
		
		while(limit > minute) {
			for(int i = 0; i < 3; i++) {
				if(i == 2)
					minute += increase[i] + K;
				else
					minute += increase[i];
				
				if(limit <= minute)
					break;
				
				if(minute >= Nstart) {
					list.add(minute);
					num++;
				}
			}
		}
		
		System.out.println(num);
		for(int a: list) 
			System.out.println(String.format("%02d:%02d", (a/60)%24, a%60));
		
		sc.close();
	}
}
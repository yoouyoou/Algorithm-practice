package b_stringExplosion;

import java.util.ArrayList;
import java.util.Collections;

public class b_9935 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		String exp_str = sc.next();
		String str = "12ab112ab2ab";
		String exp_str = "12ab";
		solution(str, exp_str);
	}
	
	public static void solution(String s1, String s2) {
		ArrayList<String> data = new ArrayList<String>();	
		int sIdx= -1, eIdx= -1, count = 0;
		
		String[] str = s1.split("");		
		String[] estr = s2.split("");
		Collections.addAll(data, str);		
		
		for(int i = 0; i < data.size(); i++) {

			if( data.get(i).equals(estr[0]) ) {	// ���߹��ڿ��� ù���� �߰�
				System.out.println("���߹��ڿ� �ǽ� ����!");
				sIdx = i;
				for(int j = sIdx; j < sIdx + estr.length; j++) { // ���߹��ڿ� �ǽɱ������� �� �� while(count != estr.length) 
					if( !data.get(j).equals(estr[count++]) ) {	// ���߹��ڿ��� ����������
						System.out.println("�� �ƴϿ���");
						count = 0;
						break;
					}
					else						// ������ ���ε��� ����
						eIdx = j;
					System.out.println("���߹��ڿ� ����("+sIdx + ", " + eIdx + ")");
				}
				
				if(count == estr.length) {		// ���߹��ڿ� ������ ���  if(check && sIdx != -1 && eIdx != -1)
					for(int j = sIdx; j <= eIdx; j++) {
						System.out.println("���ﰪ: " + data.get(sIdx));
						data.remove(sIdx);
					}
					i = sIdx - estr.length;	// Ȯ����ġ���� �ڿ� ���ڿ��� ��ܿ����ϱ� ���߹��ڿ�������ŭ�� �����ΰ��� ��ܿ� �ְ� �տ� �ֶ� ���ļ� �� �������� Ȯ��
					if(i < 0)		// �ٵ� �ʹ� �ʹݿ� �߰ߵǸ� ���̳ʽ�����ִµ� �׶��� �� ó������ �ٽ� �����
						i = -1;		// -1�� ������ �̰ų����鼭 i�� ������ ����Ǳ� ����
					System.out.println("���߹��ڿ� ������ ����� ��ȭ�� i��: " + i);
				}
				count = 0;
			}
		}
			
		if(data.isEmpty())
			System.out.println("FRULA");
		else
			for(int i = 0; i < data.size(); i++)
				System.out.print(data.get(i));
	}

}


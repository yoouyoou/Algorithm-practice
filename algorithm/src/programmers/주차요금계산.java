package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ������ݰ�� {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

//		int[] fees = {120, 0, 60, 591};
//		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		
		for(int a: solution(fees, records)) {
			System.out.print(a + " ");
		}
	}
	
    public static int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, Integer> timeMap = new HashMap<>();		//�����ð� ��� ��
        Map<String, String> entryMap = new HashMap<>();		//�����ð� ��� ��
        Map<String, Integer> ansMap = new HashMap<>();		//������ û�����
        int basicMinute = fees[0], basicFee = fees[1];
        int unitMinute = fees[2],  unitFee = fees[3];
        
        for(int i = 0; i < records.length; i++) {
        	String[] str = records[i].split(" ");
        	
        	if(str[2].equals("IN")) {
        		entryMap.put(str[1], str[0]);
        	}
        	else {
        		System.out.println("���� " + str[1]);
        		String[] str2 = entryMap.get(str[1]).split(":");
        		int ih = Integer.parseInt(str2[0]);
        		int im = Integer.parseInt(str2[1]);
        		
        		System.out.print("���� ��: " + ih + ", ");
        		System.out.print("���� ��: " + im + " / ");
        		
        		String[] str3 = str[0].split(":");
        		int oh = Integer.parseInt(str3[0]);
        		int om = Integer.parseInt(str3[1]);
        		int diff;
        		
        		if(om >= im)
        			diff = (oh-ih)*60 + (om-im);
        		else
        			diff = (60-im+om) + (oh-ih+1) * 60;
//        		int diff = om >= im ? (oh-ih) * 60 + (om-oh) : (60-im+om) + (oh-ih+1) * 60;
        		
        		System.out.print("���� ��: " + oh + ", ");
        		System.out.println("���� ��: " + om + " ");
        		System.out.println("���� ��: " + diff);
        		
        		if(timeMap.containsKey(str[1])) {
        			System.out.print("�̹� �ִ� timeMap�� ����! " );
        			timeMap.put(str[1], timeMap.get(str[1]) + diff);
        		}
        		else
        			timeMap.put(str[1], diff);	
        		
        		System.out.println("���� save�� �� " + str[1] + "- " + timeMap.get(str[1]));
        	}
        }
        
        String[] cars = new String[timeMap.size()];
        int idx = 0;
        
        //��� ����ϱ�
        for(String car : timeMap.keySet()) {
        	System.out.println(car);
        	int fee = 0;
        	int minute = timeMap.get(car);
        	cars[idx++] = car;
        	
        	if(minute <= basicMinute)
        		fee = basicFee;
        	else
        		fee = (int) (Math.ceil(minute - basicMinute) / unitMinute * unitFee) + basicFee;
        	
        	ansMap.put(car, fee);
        }
        
        answer = new int[cars.length];
        Arrays.sort(cars);
        idx = 0;
        for(String car: cars) {
        	answer[idx++] = ansMap.get(car);
        }
        
        return answer;
    }

}

package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 주차요금계산 {

	static Map<String, Integer> timeMap;
	static Map<String, String> entryMap;
	static Map<String, Integer> ansMap;
	
	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		for(int a: solution(fees, records)) {
			System.out.print(a + " ");
		}
	}
	
    public static int[] solution(int[] fees, String[] records) {
        Set<String> set = new HashSet<>();
        int basicMinute = fees[0], basicFee = fees[1];
        int unitMinute = fees[2],  unitFee = fees[3];
        timeMap = new HashMap<>();		//차량별 누적 주차시간
        entryMap = new HashMap<>();		//차량별 입차 시간
        ansMap = new HashMap<>();		//차량별 청구요금
        
        for(int i = 0; i < records.length; i++) {
        	String[] str = records[i].split(" ");
        	
        	if(str[2].equals("IN")) {
        		set.add(str[1]);
        		entryMap.put(str[1], str[0]);
        	}
        	else {
        		set.remove(str[1]);
        		saveTime(str[1], entryMap.get(str[1]), str[0]);
        	}
        }
        
        //입차 후 출차하지 못한 차 반복
        for(String car: set)
        	saveTime(car, entryMap.get(car), "23:59");
        
        String[] cars = new String[timeMap.size()];
        int[] answer = new int[cars.length];
        int idx = 0;
        
        //요금 계산하기
        for(String car : timeMap.keySet()) {
        	int fee = 0;
        	int minute = timeMap.get(car);	//차량이 주차되어있던 시간
        	cars[idx++] = car;
        	
        	if(minute <= basicMinute)
        		fee = basicFee;
        	else {
        		double temp = (minute- basicMinute) / (double)unitMinute;
        		fee = ((int)Math.ceil(temp)) * unitFee + basicFee;
        	}
        	
        	ansMap.put(car, fee);
        }
  
        Arrays.sort(cars);
        idx = 0;
        for(String car: cars)
        	answer[idx++] = ansMap.get(car);

        return answer;
    }

    public static void saveTime(String car, String inTime, String outTime) {
		String[] str2 = inTime.split(":");
		int ih = Integer.parseInt(str2[0]);
		int im = Integer.parseInt(str2[1]);
		
		String[] str3 = outTime.split(":");
		int oh = Integer.parseInt(str3[0]);
		int om = Integer.parseInt(str3[1]);
		
		int diff = om >= im ? (oh-ih)*60 + (om-im) : (oh - (ih + 1)) * 60 + (60- im + om);
//		if(om >= im)
//			diff = (oh-ih)*60 + (om-im);
//		else 
//			diff = (oh - (ih + 1)) * 60 + (60- im + om);
		
		System.out.println(ih + ":" + im + "~" + oh +":"+om + " = " + diff);
		
		if(timeMap.containsKey(car))
			timeMap.put(car, timeMap.get(car) + diff);
		else
			timeMap.put(car, diff);	
		
		System.out.println("현재 save된" + car + "는 " + timeMap.get(car) + "분\n");
    }
}

package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위검색 {

	static HashMap<String, List<Integer>> map;
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50" };
		
		String[] query = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150" };
		
		for(int a: solution(info, query))
			System.out.print(a + " ");
	}
	
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<String, List<Integer>>();
		
		for(int i = 0; i < info.length; i++) {
			String[] s = info[i].split(" ");
			combInfo(s, "", 0);
		}
		
		for(String key: map.keySet())
			Collections.sort(map.get(key));
		
		for(int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] s = query[i].split(" ");
			answer[i] = map.containsKey(s[0]) ? binarySearch(s[0], Integer.parseInt(s[1])) : 0;
		}
		
		return answer;
	}
	
    private static void combInfo(String[] p, String str, int cnt) {
        if (cnt == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<Integer>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        combInfo(p, str + "-", cnt + 1);
        combInfo(p, str + p[cnt], cnt + 1);
    }
	
	
    private static int binarySearch(String key, int score) {
        List<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;
 
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
 
        return list.size() - start;
    }

}

/*class Applicant implements Comparable<Applicant>{
	char[] arr = new char[4];
	int test;
	
	Applicant(char[] arr, int test) {
		this.arr = arr;
		this.test = test;
	}

	@Override
	public int compareTo(Applicant arg0) {
		if(arg0.test > this.test)
			return -1;
		else
			return 1;
	}

	
}*/

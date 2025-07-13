package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class b_22860 {
	
	static int count;
	static HashSet<String> set;
	static HashMap<String, ArrayList<String>> fileMap;
	static HashMap<String, ArrayList<String>> folderMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] param = br.readLine().split(" ");
		int N = Integer.parseInt(param[0]);
		int M = Integer.parseInt(param[1]);
		
		fileMap = new HashMap<>();
		folderMap = new HashMap<>();
		fileMap.put("main", new ArrayList<String>());
		folderMap.put("main", new ArrayList<String>());
		
		for(int i = 0; i < N + M; i++) {
			param = br.readLine().split(" ");
			String top = param[0];
			String cur = param[1];
			int folderYn = Integer.parseInt(param[2]);
			
			//폴더인 경우
			if(folderYn == 1) {
				if(!fileMap.containsKey(cur)) {
					folderMap.put(cur, new ArrayList<String>());
					fileMap.put(cur, new ArrayList<String>());
				}
				
				if(!folderMap.containsKey(top)) {
					folderMap.put(top, new ArrayList<String>());
					fileMap.put(top, new ArrayList<String>());					
				}
				
				ArrayList<String> list = folderMap.get(top);
				list.add(cur);
				folderMap.put(top, list);
			//파일인 경우
			}else {
				if(!folderMap.containsKey(top)) {
					folderMap.put(top, new ArrayList<String>());
					fileMap.put(top, new ArrayList<String>());					
				}
				ArrayList<String> list = fileMap.get(top);
				list.add(cur);
				fileMap.put(top, list);
			}
		}
		
		//쿼리 파일 개수 계산
		int Q = Integer.parseInt(br.readLine());
		for(int i = 0; i < Q; i++) {
			count = 0;
			set = new HashSet<>();
			String[] query = br.readLine().split("/");
			countFile(query[query.length - 1]);
			
			System.out.println(set.size() + " " + count);
		}
	}
	
	public static void countFile(String name) {
		ArrayList<String> folders = folderMap.get(name);
		if(folders == null) return;
		for(String folder: folders)
			countFile(folder);
		
		ArrayList<String> files = fileMap.get(name);
		if(files == null) return;
		for(String file: files) {
			count++;
			set.add(file);
		}
	}
}

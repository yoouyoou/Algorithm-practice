package leetcode;

public class l_2559 {

	public static void main(String[] args) {
		String[] w = {"bzmxvzjxfddcuznspdcbwiojiqf","mwguoaskvramwgiweogzulcinycosovozppl","uigevazgbrddbcsvrvnngfrvkhmqszjicpieahs","uivcdsboxnraqpokjzaayedf","yalc","bbhlbmpskgxmxosft","vigplemkoni","krdrlctodtmprpxwditvcps","gqjwokkskrb","bslxxpabivbvzkozzvdaykaatzrpe","qwhzcwkchluwdnqjwhabroyyxbtsrsxqjnfpadi","siqbezhkohmgbenbkikcxmvz","ddmaireeouzcvffkcohxus","kjzguljbwsxlrd","gqzuqcljvcpmoqlnrxvzqwoyas","vadguvpsubcwbfbaviedr","nxnorutztxfnpvmukpwuraen","imgvujjeygsiymdxp","rdzkpk","cuap","qcojjumwp","pyqzshwykhtyzdwzakjejqyxbganow","cvxuskhcloxykcu","ul","axzscbjajazvbxffrydajapweci"};
		int[][] q ={{4, 4},{6, 17},{10, 17},{9, 18},{17, 22},{5, 23},{2, 5},{17, 21},{5, 17},{4, 8},{7, 17},{16, 19},{7, 12},{9, 20},{13, 23},{1, 5},{19, 19}}; 
			//{{0,2},{1,4},{1,1}};
		
		for(int a: vowelStrings(w, q))
			System.out.print(a + ", ");
	}

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];
    	int[] count = new int[words.length];
        
    	for(int i = 0; i < words.length; i++) {
    		String word = words[i];
    		char l = word.charAt(0);
    		char r = word.charAt(word.length() - 1);
    		
    		if((l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u') && (r == 'a' || r == 'e' || r == 'i' || r == 'o' || r == 'u')) {
    			count[i]++;
    		}
    	}
    	
    	for(int a: count)
    		System.out.print(a + ", ");
    	System.out.println("");
    	
        for(int i=0;i < queries.length; i++){
            int sum=0;
            int x= queries[i][0];
            int y=queries[i][1];
            for(int j=x;j<=y;j++){
                sum += count[j];
            }
            ans[i]=sum;
        }
    	
    	return ans;
    }
}

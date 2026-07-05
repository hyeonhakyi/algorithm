import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            String str1 = cloth[0];
            String str2 = cloth[1];
            
            map.put(str2,map.getOrDefault(str2,0) + 1);
        }
        
        for(String str : map.keySet()){
            answer *= map.get(str) + 1;
        }
        
        return answer - 1;
    }//solution end
}//class end
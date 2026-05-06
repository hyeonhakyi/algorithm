import java.util.*;

class Solution {
    public int solution(String[][] clothes) {        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String[] clothe : clothes){
            String fir = clothe[0];
            String sec = clothe[1];
            
            map.put(sec,map.getOrDefault(sec,0) + 1);
        }
        
        List<Integer> list = new LinkedList(map.values());
        
        int answer = 1;
        
        for(int i : list){
            answer *= (i + 1);
        }
        
        return answer - 1;
    }//solution end
}//class end
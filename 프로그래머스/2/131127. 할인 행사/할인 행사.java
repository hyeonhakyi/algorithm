import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i],number[i]);
        }
        
        for(int j = 0; j < discount.length - 9; j++){
            int idx = 0;
            Map<String,Integer> disMap = new HashMap<String,Integer>();
            
            for(int i = 0; i < 10; i++){
                disMap.put(discount[i + j], disMap.getOrDefault(discount[i + j],0) + 1);
            }
            
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(disMap.containsKey(entry.getKey()) && entry.getValue() <= disMap.get(entry.getKey())){
                    idx++;
                }
            }
            
            if(idx == want.length){
                answer++;
            }
        }
        
      
        return answer;
    }
}
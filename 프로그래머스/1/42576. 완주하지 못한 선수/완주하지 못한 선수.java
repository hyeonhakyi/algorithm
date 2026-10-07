import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String str : participant){
            map.put(str,map.getOrDefault(str,0) + 1);
        }
        
        for(String com : completion){
            map.put(com,map.get(com) - 1);
        }
        
        for(String str : participant){
            if(map.get(str) > 0){
                answer = str;
            }
        }
        
        return answer;
    }//solution end
}//class end
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> set = new HashMap<>();
        String answer = "";
        
        for(int i = 0; i < participant.length; i++){
            if(set.get(participant[i]) != null){
                set.put(participant[i],set.get(participant[i]) + 1);
            }else{
                set.put(participant[i], 1);
            }
        }
        
        for(int i = 0; i < completion.length; i++){
            if(set.get(completion[i]) != null){
                set.put(completion[i], set.get(completion[i])-1);
            }
        }
        
        for(String key : set.keySet()){
            if(set.get(key)!=0){
                answer = key;
            }
        }
        
        return answer;
    }
}
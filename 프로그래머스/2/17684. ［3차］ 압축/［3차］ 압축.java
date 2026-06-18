import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String,Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < 26; i++){
            char c = (char)('A' + i);
            map.put(String.valueOf(c),i + 1);
        }
        
        int nextIdx = 27;
        String w = "";
        
        for(int i = 0; i < msg.length(); i++){
            char c = msg.charAt(i);
            String wc = w + c;
            
            if(map.containsKey(wc)){
                w = wc;
            }else{
                result.add(map.get(w));
                map.put(wc,nextIdx++);
                w = String.valueOf(c);
            }
        }
        
        if(!w.equals("")){
            result.add(map.get(w));
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }//solution end
}//class end
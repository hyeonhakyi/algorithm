import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> wantMap = new HashMap<>();
        
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i],number[i]);
        }
        
        for(int i = 0; i <= discount.length - 10; i++){
            HashMap<String,Integer> map = new HashMap<>();

            for(int j = i; j < i + 10; j++){
                map.put(discount[j],map.getOrDefault(discount[j],0) + 1);
            }
            
            boolean check = true;
            
            for(String str : wantMap.keySet()){
                if(map.get(str) != wantMap.get(str)){
                    check = false;
                    break;
                }
            }
            
            if(check){
                answer++;
            }
        }
        
        return answer;
    }//solution end
}//class end
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int today = 0;
        for(int i : number){
            today += i;
        }
        
        for(int i = 0; i <= discount.length - today; i++){
            HashMap<String,Integer> map = new HashMap<>();
            
            for(int j = i; j < i + today; j++){
                map.put(discount[j],map.getOrDefault(discount[j],0) + 1);
            }
            
            if(check(map,want,number)){
                answer++;
            }
        }

        return answer;
    }//solution end
    
    private static boolean check(HashMap<String,Integer> map,String[] want,int[] number){
        for(int i = 0; i < want.length; i++){
           if(map.getOrDefault(want[i],0) != number[i]){
              return false; 
            }
        }
        return true;
    }//check end
}//class end
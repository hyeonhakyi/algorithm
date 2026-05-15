import java.util.*;

class Solution {
    static int answer;
    public int solution(String[] want, int[] number, String[] discount) {
        answer = 0;
        
        int totalDay = 0;
        for(int i : number){
            totalDay += i;
        }
        
        for(int i = 0; i <= discount.length - totalDay; i++){
            Map<String,Integer> map = new HashMap<>();
            
            for(int j = i; j < i + totalDay; j++){
                map.put(discount[j],map.getOrDefault(discount[j],0) + 1);
            }
            if(check(map,want,number)){
                        answer++;
            }
        }
        
        return answer;
    }//solution end
    
    private static boolean check(Map<String,Integer> map,String[] want,int[] number){
        for(int i = 0; i < want.length; i++){
            if(map.getOrDefault(want[i], 0) != number[i]){
                return false;
            }
        }
        return true;
    }//check end
}//class end
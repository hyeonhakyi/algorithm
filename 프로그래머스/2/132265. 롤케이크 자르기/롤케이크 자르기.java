import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer,Integer> right = new HashMap<>();
        
        Set<Integer> left = new HashSet<>();
        
        for(int i = 0; i < topping.length; i++){
            right.put(topping[i],right.getOrDefault(topping[i],0) + 1);
        }
        
        for(int i = 0; i < topping.length - 1; i++){
            int now = topping[i];
            
            left.add(now);
            
            right.put(topping[i],right.get(now) - 1);
            
            if(right.get(now) == 0){
                right.remove(now);
            }
            
            if(left.size() == right.size()){
                answer++;
            }
        }
        
        return answer;
    }//solution end
}//class end
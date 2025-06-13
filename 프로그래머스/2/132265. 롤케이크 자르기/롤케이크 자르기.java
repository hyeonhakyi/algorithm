import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> order = new HashMap<>();
        Map<Integer, Integer> younger = new HashMap<>();
        
        for(int i : topping){
            younger.put(i,younger.getOrDefault(i,0) + 1);
        }
        
        for(int i : topping){
            order.put(i,order.getOrDefault(i,0) + 1);
            
            if(younger.get(i) - 1 == 0){
                younger.remove(i);
            }else{
                younger.put(i,younger.get(i) - 1);
            }
            
            if(order.size() == younger.size()){
                answer++;
            }
        }
        
        return answer;
    }
}
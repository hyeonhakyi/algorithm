import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> order = new HashMap<>();
        Map<Integer, Integer> young = new HashMap<>();
        
        for(int i : topping){
            young.put(i, young.getOrDefault(i,0) +1);
        }
        
        for(int i : topping){
            order.put(i, order.getOrDefault(i,0) +1);
            
            if(young.get(i) - 1 == 0){
                young.remove(i);
            }else{
                young.put(i,young.get(i) -1);
            }
            
            if(order.size() == young.size()){
                answer++;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }
        
        int totalWeight = 0;
        int idx = 0;
        
        while(idx < truck_weights.length){
            time++;
            
            totalWeight -= q.poll();
            
            if(totalWeight + truck_weights[idx] <= weight){
                q.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            }else{
                q.offer(0);
            }
        }
        
        return time + bridge_length;
    }//solution end
}//class end
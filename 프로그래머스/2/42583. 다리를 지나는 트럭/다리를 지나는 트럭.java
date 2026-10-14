import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }
        
        int total = 0;
        int totalCount = 0;
        int idx = 0;
        while(idx < truck_weights.length){
            total -= q.poll();
            totalCount++;
            
            if(weight < (total + truck_weights[idx])){
                q.offer(0);
            }else{
                q.offer(truck_weights[idx]);
                total += truck_weights[idx];
                idx++;
            }
        }
        
        while(!q.isEmpty()){
            q.poll();
            totalCount++;
        }
        
        return totalCount;
    }//solution end
}//class end
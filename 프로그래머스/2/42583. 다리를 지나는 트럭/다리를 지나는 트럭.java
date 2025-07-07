import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }
        
        if(bridge_length == 1) return truck_weights.length;
        if(truck_weights.length == 1) return bridge_length + 1;
        
        int idx = 0;
        int sum = 0;
        
        while(idx < truck_weights.length){
            sum -= q.poll();
            answer++;
            
            if(sum + truck_weights[idx] <= weight){
                q.offer(truck_weights[idx]);
                sum += truck_weights[idx++];
            }else{
                q.offer(0);
            }
        }
        
        return answer + bridge_length;
    }
}
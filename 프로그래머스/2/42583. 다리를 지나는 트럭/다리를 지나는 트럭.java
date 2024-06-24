import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        int idx = 0;
        int nowCur = 0;
        
        if(bridge_length == 1) return truck_weights.length + 1;
        if(truck_weights.length == 1) return bridge_length + 1;
        
        while(idx < truck_weights.length){
            
            nowCur -= bridge.poll();
            answer++;
            
            if(nowCur + truck_weights[idx] <= weight){
                bridge.offer(truck_weights[idx]);
                nowCur += truck_weights[idx++];
            }else{
                bridge.offer(0);
            }
        }
        
        return answer + bridge_length;
    }
}
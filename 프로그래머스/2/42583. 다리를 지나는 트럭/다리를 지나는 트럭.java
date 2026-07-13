import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }
        
        int totalSum = 0;
        int idx = 0;
        while(idx < truck_weights.length){
            totalSum -= q.poll();
            
            answer++;
            if(totalSum + truck_weights[idx] <= weight){
                totalSum += truck_weights[idx];
                q.offer(truck_weights[idx]);
                idx++;
            }else{
                q.offer(0);
            }
        }
        
        while(q.isEmpty()){
            answer++;
        }
        
        return answer + bridge_length;
    }//solution end
}//class end
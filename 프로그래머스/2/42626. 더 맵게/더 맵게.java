import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> q = new PriorityQueue<>();
        
        for(int i : scoville){
            q.offer((long) i);
        }
        
        while(!q.isEmpty() && q.peek() < K){
            answer++;
            
            if (q.size() < 2) {
                return -1;
            }
            
            long first = q.poll();
            long second = q.poll();
            
            q.offer(first + (second * 2));
        }
        
        return answer;
    }//solution end
}//class end
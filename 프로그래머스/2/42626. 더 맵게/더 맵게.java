import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i : scoville){
            q.offer(i);
        }
        
        while(!q.isEmpty() && q.peek() < K){
            answer++;
            
            if(q.size() < 2){
                return -1;
            }
            
            int first = q.poll();
            int second = q.poll();
            
            q.offer(first + (second * 2));
        }
        
        return answer;
    }//solution end
}//class end
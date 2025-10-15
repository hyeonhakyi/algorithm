import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville){
            pq.offer(i);
        }
        
        while(pq.peek() < K){
            if(pq.size() == 1){
                return -1;
            }
            
            int fir = pq.poll();
            int sec = pq.poll();
            int sum = fir + (sec * 2);
            pq.offer(sum);
            
            answer++;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i : scoville){
            q.offer(i);
        }
        
        while(q.peek() < K){
            if(q.size() == 1){
                return -1;
            }
            
            int fir = q.poll();
            int sec = q.poll();
            int sum = fir + (sec * 2);
            q.offer(sum);
            answer++;
        }
        
        return answer;
    }
}
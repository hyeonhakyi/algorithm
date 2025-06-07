import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n > 0){
            int now = pq.poll();
            if(now == 0){
                break;
            }
            n--;
            pq.offer(now - 1);
        }
        
        while(!pq.isEmpty()){
            int now = pq.poll();
            
            answer += now * now;
        }
        
        
        return answer;
    }
}
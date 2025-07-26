import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i : works){
            q.offer(i);
        }
        
        while(n > 0){
            int now = q.poll();
            
            if(now == 0){
                break;
            }
            n--;
            q.offer(now - 1);
        }
        
        if(q.isEmpty()){
            return 0;
        }else{
            while(!q.isEmpty()){
                int now = q.poll();
                answer += now * now;
            }
        }
        
        return answer;
    }
}
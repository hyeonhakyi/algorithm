import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        int sum = 0;
        for(int i : works){
            sum += i;
            q.offer(i);
        }
        
        if(sum <= n){
            return 0;
        }
        
        while(n --> 0){
            int now = q.poll();
            q.offer(now - 1);
        }
        
        while(!q.isEmpty()){
            int now = q.poll();
            answer += (now * now);
        }
        
        return answer;
    }//solution end
}//class end
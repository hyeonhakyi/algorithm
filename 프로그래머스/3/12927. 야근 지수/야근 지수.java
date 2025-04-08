import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i < works.length; i++){
            pq.offer(works[i]);
        }
        
        while(n > 0){
            int num = pq.poll();
            if(num == 0) break;
            num--;
            n--;
            pq.offer(num);
        }
        
        while(!pq.isEmpty()){
            int num = pq.poll();
            answer += num*num;
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : priorities){
            p.offer(i);
        }
        
        while(!p.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorities[i] == p.peek()){
                    p.poll();
                    answer++;
                
                    if(i == location){
                        return answer;
                    }
                }
            }    
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a,b) -> b - a);
        
        for(int i : enemy){
            q.offer(i);
            n -= i;
            
            if(n < 0){
                if(k > 0){
                    n += q.poll();
                    k--;
                }else{
                    break;
                }
            }
            answer++;
        }
        
        
        return answer;
    }
}
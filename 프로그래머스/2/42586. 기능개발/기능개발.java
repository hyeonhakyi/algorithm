import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> answer = new Stack<>();
        
        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                q.offer((100 - progresses[i]) / speeds[i]);
            }else{
                q.offer((100 - progresses[i]) / speeds[i] +1);
            }
        }
        
        int now = q.poll();
        int count = 1;
        
        while(!q.isEmpty()){
            if(now >= q.peek()){
                count++;
                q.poll();
            }else{
                answer.add(count);
                now = q.poll();
                count = 1;
            }
        }
        
        answer.add(count);
        int[] in = new int[answer.size()];
        
        for(int i = 0; i < answer.size(); i++){
            in[i] = answer.get(i);
        }
        
        return in;
    }
}
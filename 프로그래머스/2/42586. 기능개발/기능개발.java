import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            if((100 - progresses[i]) % speeds[i] == 0){
                que.offer((100-progresses[i]) / speeds[i]);
            }else{
                que.offer(((100 - progresses[i]) / speeds[i] +1));
            }
        }
        
        int now = que.poll();
        int count = 1;
        
        while(!que.isEmpty()){
            if(now >= que.peek()){
                count++;
                que.poll();
            }else{
                answer.add(count);
                count = 1;
                now = que.poll();
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
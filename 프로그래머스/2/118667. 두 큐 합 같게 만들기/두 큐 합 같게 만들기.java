import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i : queue1){
            q1Sum += i;
            q1.add(i);
        }
        
        for(int i : queue2){
            q2Sum += i;
            q2.add(i);
        }
        
        long total = q1Sum + q2Sum;
        
        if(total % 2 != 0){
            return -1;
        }
        
        int limit = queue1.length * 4;
        long target = total / 2;
        
        while(answer <= limit){
            if(target == q1Sum){
                return answer;
            }
            
            if(q1Sum > target){
                int num = q1.poll();
                q1Sum -= num;
                q2Sum += num;
                q2.add(num);
            }else{
                int num = q2.poll();
                q2Sum -= num;
                q1Sum += num;
                q1.add(num);
            }
            
            answer++;
        }
        
        return -1;
    }//solution end
}//class end
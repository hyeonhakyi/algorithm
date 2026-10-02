import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        
        for(long i : queue1){
            q1Sum += i;
            q1.add(i);
        }
        
        for(long i : queue2){
            q2Sum += i;
            q2.add(i);
        }
        
        long limit = queue1.length * 4;
        long total = (q1Sum + q2Sum);
        long target = (q1Sum + q2Sum) / 2;
        
        if(total % 2 != 0){
            return -1;
        }
        
        while(answer <= limit){
            if(q1Sum == target){
                return answer;
            }
            
            if(q1Sum > target){
                long num = q1.poll();
                q1Sum -= num;
                q2Sum += num;
                q2.add(num);
            }else{
                long num = q2.poll();
                q1Sum += num;
                q2Sum -= num;
                q1.add(num);
            }
            answer++;
        }
        
        return -1;
    }//solution end
}//class end
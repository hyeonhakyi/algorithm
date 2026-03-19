import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < sequence.length; i++){
            long v1;
            if(i % 2 == 0){
                v1 = sequence[i];
            }else{
                v1 = -sequence[i];
            }
            long v2 = -v1;
            
            sum1 = Math.max(v1, sum1 + v1);
            sum2 = Math.max(v2, sum2 + v2);
            
            answer = Math.max(answer,Math.max(sum1,sum2));
        }
        
        return answer;
    }//solution end
}//class end
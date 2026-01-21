import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 1;
        long right = (long) 1_000_000_000 * (long) 1_000_000_000;
        
        while(left <= right){
            long mid = (left + right) / 2;
            
            long sum = 0;
            for(int i : times){
                sum += mid / i;
                if(sum >= n) break;
            }
            
            if(sum >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }//main end
}//class end
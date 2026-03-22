import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long left = 1;
        long right = 0;
        
        for(int i : times){
            right = Math.max(i,right);
        }
        
        right *= n;
        
        while(left <= right){
            long mid = (left + right) / (long) 2;
            long sum = 0;
            for(int i : times){
                sum += mid / i;
                if(sum >= n){
                    break;
                }
            }
            
            if(sum >= n){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return answer;
    }//solution end
}//class end
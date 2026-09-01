import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 1;
        int start = 1;
        int end = 1;
        
        while(start <= end){
            if(sum == n){
                answer++;
                sum -= start;
                start++;
            }else if(sum < n){
                end++;
                if(end > n) break;
                sum += end;
            }else{
                sum -= start;
                start++;
            }
        }
        
        return answer;
    }//solution end
}//class end
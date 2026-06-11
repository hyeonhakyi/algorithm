import java.util.*;

class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;
        
        long coreCnt = cores.length;
        
        if(coreCnt >= n){
            return n;
        }
        
        int left = 0;
        int right = 10000 * n;
        int time = 0;
        while(left <= right){
            int mid = (left + right) / 2;
            
            long count = coreCnt;
            
            for(int i : cores){
                count += mid / i;
            }
            
            if(count >= n){
                right = mid - 1;
                time = mid;
            }else{
                left = mid + 1;
            }
        }
        
        long prevCnt = coreCnt;
        
        for(int i : cores){
            prevCnt += (time - 1) / i;
        }
        
        long remain = n - prevCnt;
        
        for(int i = 0; i < cores.length; i++){
            if(time % cores[i] == 0){
                remain--;
                
                if(remain == 0){
                    answer = i + 1;
                }
            }
        }
        
        return answer;
    }//solution end
}//class end
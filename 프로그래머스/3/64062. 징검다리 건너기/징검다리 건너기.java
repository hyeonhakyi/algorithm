import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 0;
        int right = 0;
        for(int s : stones){
            right = Math.max(right,s);
        }
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(canCross(mid,stones,k)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return answer;
    }//solution end
    
    private static boolean canCross(int mid,int[] stones,int k){
        int kCnt = 0;
        for(int s : stones){
            if(s - mid < 0){
                kCnt++;
                if(kCnt >= k){
                    return false;
                }
            }else{
                kCnt = 0;
            }
        }
        return true;
    }//canCross end
}//class end
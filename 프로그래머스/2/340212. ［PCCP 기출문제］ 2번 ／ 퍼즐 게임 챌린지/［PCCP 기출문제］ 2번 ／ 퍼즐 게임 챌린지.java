import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int left = 1;
        int right = 100000;
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(canCount(diffs,times,limit,mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        
        return answer;
    }//main end
    
    private static boolean canCount(int[] diffs,int[] times, long limit,int level){
        long timeSum = 0;
        
        for(int i = 0; i < diffs.length; i++){
            int diff = diffs[i];
            int time = times[i];
            int timePrev;
            
            if(i == 0){
                timePrev = 0;
            }else{
                timePrev = times[i - 1];
            }
            
            if(diff <= level){
                timeSum += time;
            }else if(diff > level){
                int cnt = diff - level;
                timeSum += (time + timePrev) * (long) cnt + time;
            }
            
            if(limit < timeSum){
                return false;
            }
        }
        
        return true;
    }//canCount end
}
import java.util.*;

class Solution {
    static long answer;
    public long solution(int n, int[] times) {
        long maxTime = (long)1000000000 * (long)1000000000;
        long minTime = 1;
        answer = maxTime;
        search(n,times,minTime,maxTime);
        return answer;
    }
    
    static void search(int n,int[] times,long start,long end){
        while(start <= end){
            long mid = (start + end) / 2;
            long timeCnt = 0;
            
            for(int t : times){
                timeCnt += (mid / t);
            }
            
            if(n <= timeCnt){
                answer = Math.min(answer,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
    }//search end
}
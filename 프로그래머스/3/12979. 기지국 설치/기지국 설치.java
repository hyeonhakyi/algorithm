import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int coverage = 2 * w +1;
        int now = 1;
        int idx = 0;
        
        while(now <= n){
            if(idx < stations.length && now >= stations[idx] - w){
                now = stations[idx] + w + 1;
                idx++;
            }else{
                answer++;
                now += coverage;
            }
        }

        return answer;
    }
}
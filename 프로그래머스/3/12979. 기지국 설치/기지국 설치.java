import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2 * w + 1;
        int idx = 0;
        int now = 1;
        
        while(now <= n){
            if(idx < stations.length && now >= stations[idx] - w){
                now = stations[idx] + w + 1;
                idx++;
            }else{
                now += cover;
                answer++;
            }
        }

        return answer;
    }//solution end
}//class end
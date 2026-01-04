import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1],b[1]));
        
        int prev = Integer.MIN_VALUE;
        for(int[] route : routes){
            int now = route[0];
            
            if(prev < now){
                answer++;
                prev = route[1];
            }
        }
        
        return answer;
    }
}
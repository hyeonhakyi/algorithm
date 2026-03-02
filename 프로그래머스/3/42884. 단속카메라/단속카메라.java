import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int n = routes.length;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1],b[1]));
        
        int prev = routes[0][1];
        int idx = 1;
        while(idx < n){
            int now = routes[idx][0];
            
            if(prev < now){
                answer++;
                prev = routes[idx][1];
            }
            
            idx++;
        }
        
        return answer;
    }//solution end
}//class end
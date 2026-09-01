import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes,(a,b) -> {
            if(a[0] == b[0]){
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        
        int prev = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            int start = routes[i][0];
            int end = routes[i][1];
            
            if(prev >= start){
                prev = Math.min(end,prev);
            }else{
                answer++;
                prev = end;
            }
        }
        
        return answer;
    }//solution end
}//class end
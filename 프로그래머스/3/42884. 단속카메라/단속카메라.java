import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes,(a,b) -> {
           if(a[0] == b[0]){
               return Integer.compare(a[1],b[1]);
           };
            return Integer.compare(a[0],b[0]);
        });
        
        int prev = routes[0][1];
        
        for(int i = 1; i < routes.length; i++){
            if(prev >= routes[i][0]){
                prev = Math.min(prev,routes[i][1]);
            }else if(prev < routes[i][0]){
                answer++;
                prev = routes[i][1];
            }
        }
        
        return answer;
    }//solution end
}//class end
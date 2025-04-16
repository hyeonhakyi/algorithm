import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1],b[1]));
        
        int count = 0;
        int preCamera = Integer.MIN_VALUE;
        
        for(int[] r:routes){
            if(r[0] > preCamera){
                preCamera = r[1];
                count++;
            }
        }
        return count;
    }
}
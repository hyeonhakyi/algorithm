import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> Integer.compare(a[1],b[1]));
        int last = Integer.MIN_VALUE;
        
        for(int[] t : targets){
            int s = t[0];
            int e = t[1];
            
            if(last <= s){
                answer++;
                last = e;
            }
        }
        
        return answer;
    }
}
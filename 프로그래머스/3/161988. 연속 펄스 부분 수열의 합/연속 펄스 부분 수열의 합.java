import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        boolean check = false;
        
        long p1 = 0;
        long p2 = 0;
        
        for(int s : sequence){
            p1 += check ? -s : s;
            p2 += check ? s : -s;
            
            p1 = Math.max(0, p1);
            p2 = Math.max(0, p2);
            
            answer = Math.max(answer,Math.max(p1,p2));
            check = !check;
        }
        
        return answer;
    }
}
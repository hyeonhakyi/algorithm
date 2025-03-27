import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1Square = (long) r1 * r1;
        long r2Square = (long) r2 * r2;
        
        for(int x = 1; x <= r2; x++){
            long yMax = (long) Math.floor(Math.sqrt(r2Square - (long) x * x));
            long yMin = (long) Math.ceil(Math.sqrt(Math.max(0,r1Square - (long) x * x)));
            
            answer += (yMax - yMin + 1);
        }
        
        return answer * 4;
    }
}
import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        int move = len - 1;
        
        for(int i = 0; i < len; i++){
            char c = name.charAt(i);
            
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up,down);
            
            int next = i + 1;
            
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            
            move = Math.min(move,i * 2 + len - next);
            move = Math.min(move,i + (len - next) * 2);
        }
        
        return answer + move;
    }//solution end
}//class end
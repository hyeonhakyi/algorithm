import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        for(int i = 0; i < length; i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        int minMovie = length - 1;
        
        for(int i = 0; i < length; i++){
            int next = i + 1;
            
            while(next < length && name.charAt(next) == 'A'){
                next++;
            }
            
            minMovie = Math.min(minMovie, i + i + (length - next));
            minMovie = Math.min(minMovie,(length - next) * 2 + i);
        }
        
        return answer + minMovie;
    }
}
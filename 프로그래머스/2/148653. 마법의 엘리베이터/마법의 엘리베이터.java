import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0){
            int dist = storey % 10;
            storey = storey / 10;
            
            if(dist == 5){
                if(storey % 10 >= 5){
                    answer += 10 - dist;
                    storey += 1;
                }else{
                    answer += dist;
                }
            }else if(dist >= 5){
                answer += (10- dist);
                storey += 1;
            }else{
                answer += dist;
            }
        } 
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        for(int i = 0; i < weights.length; i++){
            int first = weights[i];
            for(int j = i + 1; j < weights.length; j++){
                int second = weights[j];
                
                if(first == second){
                    answer++;
                }else if((first * 4) == (second * 2)){
                    answer++;
                }else if((first * 3) == (second * 2)){
                    answer++;
                }else if((first * 4) == (second * 3)){
                    answer++;
                }
            }
        }
        
        return answer;
    }//solution end
}//class end
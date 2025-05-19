import java.util.*;

class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] count = new int[e+1];
        
        for(int i = 1; i <= e; i++){
            for(int j = i; j <= e; j += i){
                count[j]++;
            }
        }
        
        int[] maxCount = new int[e + 1];
        int maxNum = e;
        maxCount[e] = e;
        
        for(int i = e-1; i > 0; i--){
            if(count[i] >= count[maxNum]){
                maxNum = i;
            }
            maxCount[i] = maxNum;
        }
        
        for(int i = 0; i < starts.length; i++){
            answer[i] = maxCount[starts[i]];
        }
        
        return answer;
    }
}
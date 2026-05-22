import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int n = citations.length;
        for(int i = 0; i < n; i++){
            int len = n - i;
            
            if(citations[i] >= len){
                answer = len;
                break;
            }
        }
        
        return answer;
    }//solution end
}//class end
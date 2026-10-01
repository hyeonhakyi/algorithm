import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int total = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int right = 0; right < sequence.length; right++){
            total += sequence[right];
            
            while(total > k){
                total -= sequence[left++];
            }
            
            if(total == k){
                int len = right - left + 1;
                
                if(len < minLen){
                    minLen = len;
                    
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        return answer;
    }//solution end
}//class end
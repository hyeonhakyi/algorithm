import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        long sum = 0;
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];
            
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                int len = right - left + 1;
                
                if(minLen > len){
                    minLen = len;
                    start = left;
                    end = right;
                }
            }
        }
        
        return new int[]{start,end};
    }//solution end
}//class end
import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int idx = sequence.length;
        int left = 0;
        int sum = 0;
        
        for(int right = 0; right < sequence.length; right++){
            sum += sequence[right];
            
            while(right < sequence.length && sum > k){
                sum -= sequence[left];
                left++;
            }
            
            if(sum == k){
                if(idx > right - left){
                    idx = right - left;
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        
        return answer;
    }
}
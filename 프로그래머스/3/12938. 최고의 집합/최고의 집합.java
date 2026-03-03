import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(s < n){
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        
        int q = s/n;
        int r = s%n;
        
        Arrays.fill(answer,q);
        
        for(int i = n - 1; i >= n - r; i--){
            answer[i]++;
        }
        
        return answer;
    }//solution end
}//class end
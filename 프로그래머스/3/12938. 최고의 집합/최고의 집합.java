import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(s < n) return new int[] {-1};
        int[] answer = new int[n];
        
        int first = s / n;
        int second = s % n;
        
        for(int i = 0; i < n; i++){
            answer[i] = first;
        }
        
        for(int i = n - 1; i >= n - second; i--){
            answer[i]++;
        }
        
        return answer;
    }
}
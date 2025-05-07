import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            min = Math.min(min,a[i]);
            leftMin[i] = min;
        }
        
        min = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            min = Math.min(min,a[i]);
            rightMin[i] = min;
        }
        
        int answer = 0;
        for(int i = 0; i < n; i++){
            if(i == 0 || i == n-1){
                answer++;
                continue;
            }
            
            if(a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]){
                answer++;
            }
        }
        
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            min = Math.min(min,a[i]);
            leftMin[i] = min;
        }
        
        min = Integer.MAX_VALUE;
        for(int i = a.length - 1; i >= 0; i--){
            min = Math.min(min,a[i]);
            rightMin[i] = min;
        }
        
        for(int i = 0; i < a.length; i++){
            if(a[i] <= leftMin[i] || a[i] <= rightMin[i] ){
                answer++;
            }
        }
        
        return answer;
    }//main end
}//class end
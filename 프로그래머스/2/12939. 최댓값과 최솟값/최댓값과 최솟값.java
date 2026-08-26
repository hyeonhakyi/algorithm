import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            int num = Integer.parseInt(arr[i]);
            
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }//solution end
}//class end
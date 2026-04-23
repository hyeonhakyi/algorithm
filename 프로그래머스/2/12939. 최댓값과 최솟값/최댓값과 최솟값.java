import java.util.*;

class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] arr = s.split(" ");
        
        for(int i = 0; i < arr.length; i++){
            max = Math.max(Integer.parseInt(arr[i]),max);
            min = Math.min(Integer.parseInt(arr[i]),min);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        
        return sb.toString();
    }//solution end
}//class end
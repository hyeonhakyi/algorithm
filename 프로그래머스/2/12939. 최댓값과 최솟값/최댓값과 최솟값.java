import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        
        int max = Integer.parseInt(sArr[0]);
        int min = Integer.parseInt(sArr[0]);
        
        for(String arr : sArr){
            int temp = Integer.parseInt(arr);
            
            if(max < temp){
                max = temp;
            }
            
            if(min > temp){
                min = temp;
            }
        }
        return min + " " + max;
    }
}
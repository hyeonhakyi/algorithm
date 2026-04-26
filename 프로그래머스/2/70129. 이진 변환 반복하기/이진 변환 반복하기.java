import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int totalRemove = 0;
        
        while(!s.equals("1")){
            int originalLength = s.length();
            
            int oneCnt = 0;
            for(int i = 0; i < originalLength; i++){
                if(s.charAt(i) == '1'){
                    oneCnt++;
                }
            }
            
            totalRemove += (originalLength - oneCnt);
            
            s = Integer.toBinaryString(oneCnt);
            
            cnt++;
        }
        
        return new int[]{cnt,totalRemove};
    }//solution end
}//class end
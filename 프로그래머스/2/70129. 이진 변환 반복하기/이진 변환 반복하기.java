import java.util.*;

class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int totalCnt = 0;
        while(!s.equals("1")){
            int len = s.length();
            
            int oneCnt = 0;
            for(int i = 0; i < len; i++){
                if(s.charAt(i) == '1'){
                    oneCnt++;
                }
            }
            
            totalCnt += (len - oneCnt);
            s = Integer.toBinaryString(oneCnt);
            cnt++;
        }
        
        return new int[]{cnt,totalCnt};
    }//solution end
}//class end
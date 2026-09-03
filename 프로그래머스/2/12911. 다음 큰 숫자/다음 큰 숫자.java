import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int target = n;
        String str = Integer.toBinaryString(n);
        int totalCnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                totalCnt++;
            }
        }
        
        while(true){
            target++;
            
            String tar = Integer.toBinaryString(target);
            int targetCnt = 0;
            for(int i = 0; i < tar.length(); i++){
                if(tar.charAt(i) == '1'){
                    targetCnt++;
                }
            }
            
            if(targetCnt == totalCnt){
                break;
            }
        }
        
        return target;
    }//solution end
}//class end
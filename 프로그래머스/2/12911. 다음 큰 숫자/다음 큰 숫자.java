import java.util.*;

class Solution {
    public int solution(int n) {
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
            if(find(target,totalCnt)){
                break;
            }
        }
        
        return target;
    }//solution end
    
    private static boolean find(int target,int total){
        String str = Integer.toBinaryString(target);
        int cnt = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                cnt++;
            }
        }
        
        if(cnt == total){
            return true;
        }
        return false;
    }//find end
}//clcass end
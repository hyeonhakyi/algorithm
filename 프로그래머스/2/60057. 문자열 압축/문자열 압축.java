import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        
        if(s.length() == 1){
            return 1;
        }
        
        for(int r = 1; r <= len/2; r++){
            String pattern = s.substring(0,r);
            int compLen = 0;
            int cnt = 1;
            
            for(int i = r; i <= s.length() - r; i += r){
                if(pattern.equals(s.substring(i,i+r))){
                    cnt++;
                }else{
                    if(cnt > 1){
                        compLen += (int)Math.log10(cnt) + 1;
                    }
                    pattern = s.substring(i, i + r);
                    compLen += pattern.length();
                    cnt = 1;
                }
            }
            
            if(cnt > 1){
                compLen += (int) Math.log10(cnt) + 1;
            }
            
            int div = s.length() %r;
            if(div > 0) {
                compLen += div;
            }
            compLen += pattern.length();
            
            answer = Math.min(answer,compLen);
        }
        
        return answer;
    }
}
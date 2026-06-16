import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder total = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        int num = 0;
        while(total.length() < t * m){
            total.append(Integer.toString(num,n).toUpperCase());
            num++;
        }
        
        for(int i = p - 1; answer.length() < t; i += m){
            answer.append(total.charAt(i));
        }
        
        return answer.toString();
    }//solution end
}//class end
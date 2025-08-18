import java.util.*;


class Solution{
    public int solution(String s){
        int answer = 0;
        
        for(int i = 0; i < s.length(); i++){
            answer = Math.max(answer,cal(s,i,i));
            
            answer = Math.max(answer,cal(s,i,i+1));
        }

        return answer;
    }//main end
    
    public int cal(String s,int left,int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return right - left - 1;
    }//cal end
}//class end
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        String str = s.toLowerCase();
        
        boolean isFirst = true;
        
        for(char c : str.toCharArray()){
            if(c == ' '){
                answer.append(c);
                isFirst = true;
            }else{
                if(isFirst){
                    answer.append(Character.toUpperCase(c));
                    isFirst = false;
                }else{
                    answer.append(c);
                }
            }
        }
        
        return answer.toString();
    }//solution end
}//class end
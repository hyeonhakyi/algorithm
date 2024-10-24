import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
    
        for(int i = 0; i < sArr.length; i++){
            if(sArr[i].length() == 0){
                answer += " ";
            }else{
                answer += sArr[i].substring(0,1).toUpperCase();
                answer += sArr[i].substring(1).toLowerCase();
                answer += " ";
            }
        }
            
        if(s.substring(s.length() - 1, s.length()).equals(" ")){
            return answer;
        }
        
        return answer = answer.substring(0,answer.length() - 1);
    }
}
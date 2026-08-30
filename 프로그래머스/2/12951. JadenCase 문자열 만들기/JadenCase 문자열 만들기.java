import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        String str = s.toLowerCase();
        
        boolean check = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            
            if(check){
                sb.append(Character.toUpperCase(c));
            }else{
                sb.append(c);
            }
            
            if(c == ' '){
                check = true;
            }else{
                check = false;
            }
        }
        
        return sb.toString();
    }//solution end
}//class end
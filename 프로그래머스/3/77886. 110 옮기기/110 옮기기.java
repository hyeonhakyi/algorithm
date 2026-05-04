import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i = 0; i < s.length; i++){
            answer[i] = solve(s[i]);
        }
        
        return answer;
    }//solution end
    
    private static String solve(String str){
        char[] stack = new char[str.length()];
        
        int top = 0;
        int count110 = 0;
        
        for(int i = 0; i < str.length(); i++){
            stack[top++] = str.charAt(i);
            
            if(top >= 3 && stack[top - 3] == '1' && stack[top - 2] == '1' && stack[top - 1] == '0'){
                top -= 3;
                count110++;
            }
        }
        
        int countPos = -1;
        
        for(int i = 0; i < top; i++){
            if(stack[i] == '0'){
                countPos = i;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= countPos; i++){
            sb.append(stack[i]);
        }
        
        for(int i = 0; i < count110; i++){
            sb.append("110");
        }
        
        for(int i = countPos + 1; i < top; i++){
            sb.append(stack[i]);
        }
        
        return sb.toString();
    }//solve end
}//class end
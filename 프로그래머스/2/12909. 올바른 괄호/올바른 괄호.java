import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(!stack.isEmpty()){
                if(c == '('){
                    stack.push(c);
                }else{
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }else{
                stack.push(c);
            }
            
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return answer;
    }//solution end
}//class end
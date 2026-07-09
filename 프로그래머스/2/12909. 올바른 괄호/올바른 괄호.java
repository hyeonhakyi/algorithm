import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char str = s.charAt(i);
            
            if(str == ')'){
                if(stack.isEmpty()){
                    return false;
                }else{
                    if(stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }else{
                stack.push(str);
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return answer;
    }//solution end
}//class end
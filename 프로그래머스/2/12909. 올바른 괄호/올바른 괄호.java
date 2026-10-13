import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char str = s.charAt(i);
            
            if(stack.isEmpty()){
                stack.add(str);
            }else{
                if(stack.peek() == '(' && str == ')'){
                    stack.pop();
                    continue;
                }else if(stack.peek() == ')'){
                    return false;
                }
                stack.add(str);
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return answer;
    }//solution end
}//class end
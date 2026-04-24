import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> stack = new Stack<>();
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ')'){
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
                stack.push(arr[i]);
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }
        
        return answer;
    }//solution end
}//class end
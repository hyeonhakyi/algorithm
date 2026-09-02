import java.util.*;

class Solution{
    public int solution(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char str = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == str){
                stack.pop();
            }else{
                stack.push(str);
            }
        }
        
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }//solution end
}//class end
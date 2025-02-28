import java.util.*;

class Solution {
    int pos;
    public String solution(String p) {        
        if(p.isEmpty()){
            return p;
        }// 1번 조건
        
        // 2번 조건
        boolean isBaln = balanceString(p);
        String u = p.substring(0,pos);
        String v = p.substring(pos,p.length());
        
        // 3번 조건
        if(isBaln){
            // 3-1
            return u + solution(v);
        }else{
            // 4번 조건
            // 4-1
            String answer = "(";
            
            // 4-2
            answer += solution(v);
            
            // 4-3
            answer += ")";
            
            // 4-4 
            for(int i = 1; i < u.length() - 1; i++){
                if(u.charAt(i) == '('){
                    answer += ")";
                }else{
                    answer += "(";
                }
            }
            return answer;
        }
    }
    
    public boolean balanceString(String s){
        Stack<Character> stack = new Stack<>();
        boolean checkBalance = true;
        int left = 0;
        int right = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
                stack.push('(');
            }else{
                right++;
                if(stack.isEmpty()){
                    checkBalance = false;
                }else{
                    stack.pop();
                }
            }
            
            if(left == right){
                pos = i + 1;
                return checkBalance;
            }
        }
        return true;
    }
}
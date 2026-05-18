import java.util.*;

class Solution {
    static char[] arr;
    static int n;
    public int solution(String s) {
        int answer = 0;
        n = s.length();
        arr = s.toCharArray();
        
        for(int i = 0; i < n; i++){
            if(check(i)){
                answer++;
            }
        }
        
        return answer;
    }//solution end
    
    private static boolean check(int idx){
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char now = arr[(idx + i) % n];

            // 수정: 여는 괄호는 무조건 stack에 넣음
            if (now == '(' || now == '{' || now == '[') {
                stack.push(now);
            } else {
                // 수정: 닫는 괄호인데 stack이 비어 있으면 잘못된 괄호 문자열
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.peek();

                // 수정: 짝이 맞으면 pop
                if (top == '(' && now == ')') {
                    stack.pop();
                } else if (top == '{' && now == '}') {
                    stack.pop();
                } else if (top == '[' && now == ']') {
                    stack.pop();
                } else {
                    // 수정: 닫는 괄호와 stack top이 짝이 안 맞으면 false
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }//check end
}//class end
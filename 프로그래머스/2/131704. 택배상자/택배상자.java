import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= order.length; i++){
            while(!stack.isEmpty() && order[idx] == stack.peek()){
                answer++;
                stack.pop();
                idx++;
            }
            
            stack.add(i);
        }
        
        while(!stack.isEmpty() && order[idx] == stack.peek()){
            answer++;
            stack.pop();
            idx++;
        }
        
        return answer;
    }//solution end
}//class end
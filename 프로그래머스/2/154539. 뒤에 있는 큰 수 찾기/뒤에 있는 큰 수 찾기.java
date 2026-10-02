import java.util.*;

class Node{
    int idx;
    int num;
    public Node(int idx,int num){
        this.idx = idx;
        this.num = num;
    }
}

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];
            
            while(!stack.isEmpty() && stack.peek().num < num){
                answer[stack.peek().idx] = num;
                stack.pop();
            }
            
            stack.push(new Node(i,num));
        }
        
        while(!stack.isEmpty()){
            answer[stack.peek().idx] = -1;
            stack.pop();
        }
        
        return answer;
    }//solution end
}//class end
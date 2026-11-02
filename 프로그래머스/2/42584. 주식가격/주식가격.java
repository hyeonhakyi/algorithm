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
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Node> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && stack.peek().num > prices[i]){
                Node now = stack.pop();
                int time = i - now.idx;
                answer[now.idx] = time;
            }
            
            stack.push(new Node(i,prices[i]));
        }
        
        while(!stack.isEmpty()){
            Node now = stack.pop();
            answer[now.idx] = prices.length - now.idx - 1;
        }
        
        return answer;
    }//solution end
}//class end
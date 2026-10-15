import java.util.*;

class Node{
    int idx;
    int value;
    public Node(int idx,int value){
        this.idx = idx;
        this.value = value;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Node> stack = new Stack<>();
        
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && stack.peek().value > prices[i]){
                Node node = stack.pop();
                answer[node.idx] = i - node.idx;
            }
            
            stack.add(new Node(i,prices[i]));
        }
        
        while(!stack.isEmpty()){
            Node node = stack.pop();
            answer[node.idx] = prices.length - 1 - node.idx;
        }
        
        return answer;
    }//solution end
}//class end
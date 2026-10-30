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
            while(!stack.isEmpty() && stack.peek().num < numbers[i]){
                Node now = stack.pop();
                answer[now.idx] = numbers[i];
            }
            
            stack.push(new Node(i,numbers[i]));
        }
        
        while(!stack.isEmpty()){
            Node now = stack.pop();
            answer[now.idx] = -1;
        }
        
        return answer;
    }//solution end
}//class end
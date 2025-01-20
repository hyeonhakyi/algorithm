import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] arr = new int[order.length];
        
        for(int i = 0; i < order.length; i++){
            arr[order[i] - 1] = i;
        }
        
        Stack<Integer> stack = new Stack<>();
        
        int target = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == target){
                target++;
            }else{
                stack.push(arr[i]);
            }
            while(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
                target++;
            }
        }
        return target;
    }
}
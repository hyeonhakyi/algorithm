import java.util.*;

class Node{
    int value;
    int idx;
    
    public Node(int value,int idx){
        this.value = value;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Node(priorities[i],i));
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            boolean check = false;
            for(Node next : q){
                if(next.value > now.value){
                    check = true;
                    break;
                }
            }
            
            if(check){
                q.offer(now);
            }else{
                answer++;
                
                if(now.idx == location){
                    return answer;
                }
            }
        }
        
        return answer;
    }//solution end
}//class end
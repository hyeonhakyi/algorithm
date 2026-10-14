import java.util.*;

class Node{
    int idx;
    int pri;
    public Node(int idx,int pri){
        this.idx = idx;
        this.pri = pri;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Node> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            q.offer(new Node(i,priorities[i]));
        }
        
        while(!q.isEmpty()){
            Node now = q.poll();
            
            boolean check = false;
            for(Node next : q){
                if(next.pri > now.pri){
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
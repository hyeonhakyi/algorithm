import java.util.*;

class Node{
    int idx;
    int prev;
    int next;
    public Node(int idx,int prev,int next){
        this.idx = idx;
        this.prev = prev;
        this.next = next;
    }
}

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        
        for(int i = 0; i < n; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        next[n - 1] = -1;
        
        char[] answer = new char[n];
        Arrays.fill(answer,'O');
        
        Stack<Node> stack = new Stack<>();
        int cur = k;
        
        for(String s : cmd){
            char a = s.charAt(0);
            
            if(a == 'U'){
                int x = Integer.parseInt(s.substring(2));
                for(int i = 0; i < x; i++){
                    cur = prev[cur];
                }
            }else if(a == 'D'){
                int x = Integer.parseInt(s.substring(2));
                for(int i = 0; i < x; i++){
                    cur = next[cur];
                }
            }else if(a == 'C'){
                stack.push(new Node(cur,prev[cur],next[cur]));
                answer[cur] = 'X';
                
                if(prev[cur] != -1){
                    next[prev[cur]] = next[cur];
                }
                if(next[cur] != -1){
                    prev[next[cur]] = prev[cur];
                }
                
                if(next[cur] != -1){
                    cur = next[cur];
                }else{
                    cur = prev[cur];
                }
            }else{
                Node stores = stack.pop();
                answer[stores.idx] = 'O';
                
                if(stores.prev != -1){
                    next[stores.prev] = stores.idx;
                }
                if(stores.next != -1){
                    prev[stores.next] = stores.idx;
                }
                
                prev[stores.idx] = stores.prev;
                next[stores.idx] = stores.next;
            }
        }
        
        return new String(answer);
    }//solution end
}//class end
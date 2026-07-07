import java.util.*;

class Solution {
    static List<Integer>[] list;
    static int answer;
    static int N;
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        N = n;
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int s = wire[0];
            int e = wire[1];
        
            list[s].add(e);
            list[e].add(s);
        }
        
        for(int[] wire : wires){
            int s = wire[0];
            int e = wire[1];
            
            int count = bfs(s,e);
            
            int other = Math.abs(count - n);
            answer = Math.min(answer,Math.abs(other - count));
        }
        
        return answer;
    }//solution end
    
    private static int bfs(int a,int b){
        Queue<Integer> q = new LinkedList();
        q.offer(1);
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        
        int count = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if((now == a && next == b) || (now == b && next == a)){
                    continue;
                }
                
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }   
        }
        
        return count;
    }//dfs end
}//class end
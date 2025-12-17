import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                dfs(i,computers,visited);
                answer++;
            }
        }
        
        return answer;
    }//main end
    
    private static void dfs(int s,int[][] computers,boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i = 0; i < computers.length; i++){
                if(!visited[i] && computers[now][i] == 1){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }//dfs end
}//class end
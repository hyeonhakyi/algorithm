import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                answer++;
                bfs(computers,i);
            }
        }
        
        return answer;
    }//solution end
    
    private static void bfs(int[][] computers,int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i = 0; i < computers.length; i++){
                if(computers[now][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }//bfs end
}//class end
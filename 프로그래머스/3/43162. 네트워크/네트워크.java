import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        visited = new boolean[n + 1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    list[i + 1].add(j + 1);
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            bfs(i);
            answer++;
        }
        
        return answer;
    }//solution end
    
    private static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(visited[next]) continue;
                q.offer(next);
                visited[next] = true;
            }
        }
    }//bfs end
}//class end
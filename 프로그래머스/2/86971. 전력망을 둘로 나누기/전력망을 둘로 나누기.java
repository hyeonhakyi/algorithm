import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        list = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int start = wire[0];
            int end = wire[1];
            
            list[start].add(end);
            list[end].add(start);
        }
        
        for(int[] wire : wires){
            int cutA = wire[0];
            int cutB = wire[1];
            
            visited = new boolean[n + 1];
            
            int count = bfs(cutA,cutB);
            
            int other = n - count;
            
            answer = Math.min(answer,Math.abs(count - other));
        }
        
        
        return answer;
    }//solution end
    
    private static int bfs(int cutA,int cutB){
        Queue<Integer> q = new LinkedList<>();
        q.offer(cutA);
        visited[cutA] = true;
        int count = 1;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list[now]){
                if(cutA == now && cutB == next) continue;
                if(cutA == next && cutB == now) continue;
                if(visited[next]) continue;
                
                visited[next] = true;
                q.offer(next);
                count++;
            }
        }
        
        return count;
    }//dfs end
}//class end
import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    ArrayList<Integer>[] g;
    public int solution(int n, int[][] wires) {
        g = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++){
            g[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int s = wires[i][0];
            int v = wires[i][1];
            
            g[s].add(v);
            g[v].add(s);
        }
        
        for(int i = 0; i < wires.length; i++){
            boolean[] visited = new boolean[n + 1];
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            g[v1].remove(Integer.valueOf(v2));
            g[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1,visited);
            int num = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer,num);
            
            g[v1].add(v2);
            g[v2].add(v1);
        }
        
        return answer;
    }
    
    public int dfs(int v, boolean[] visited){
        visited[v] = true;
        int cnt = 1;
        for(int next : g[v]){
            if(visited[next]) continue;
            cnt += dfs(next,visited);
        }
        return cnt;
    }
}